package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallspotviews;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.UserNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotMetadataPortMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPersonalizationMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPortMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata.SpotMetadataLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.user.UserLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewListResponse;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class GetAllSpotViewsHandler implements GetAllSpotViewsUseCase {
    private final SpotPersonalizationRepository repository;
    private final UserLookupPort userLookupPort;
    private final SpotLookupPort spotLookupPort;
    private final SpotMetadataLookupPort spotMetadataLookupPort;
    private final SpotPersonalizationMapper mapper = new SpotPersonalizationMapper();
    private final SpotPortMapper spotPortMapper = new SpotPortMapper();
    private final SpotMetadataPortMapper spotMetadataPortMapper = new SpotMetadataPortMapper();

    public GetAllSpotViewsHandler(SpotPersonalizationRepository repository,
                                  UserLookupPort userLookupPort,
                                  SpotLookupPort spotLookupPort,
                                  SpotMetadataLookupPort spotMetadataLookupPort) {
        this.repository = repository;
        this.userLookupPort = userLookupPort;
        this.spotLookupPort = spotLookupPort;
        this.spotMetadataLookupPort = spotMetadataLookupPort;
    }

    @Override
    public SpotViewListResponse execute(GetAllSpotViewsQuery query) {
        List<SpotPersonalization> spotPersonalizations = new ArrayList<>();

        List<SpotId> personalSpotIds = new ArrayList<>();
        if(query.userId().isPresent()) {
            UserId userIdReceived = UserId.of(query.userId().get());

            if(!userLookupPort.doesUserExist(userIdReceived)) {
                throw new UserNotFoundException();
            }

            spotPersonalizations = repository.findByUserId(userIdReceived);
            personalSpotIds = spotPersonalizations.stream()
                    .map(SpotPersonalization::spotId)
                    .toList();

        }

        List<Spot> publicSpots = spotLookupPort.getAllPublicSpots().stream()
                .map(spotPortMapper::toSpot)
                .toList();

        List<SpotId> publicSpotIds = publicSpots.stream()
                .map(Spot::spotId)
                .toList();

        List<SpotId> personalSpotIdsStillNeeded = personalSpotIds.stream()
                .filter(personalSpotId -> !publicSpotIds.contains(personalSpotId))
                .toList();

        List<Spot> personalSpots = spotLookupPort.loadSpots(personalSpotIdsStillNeeded).stream()
                .map(spotPortMapper::toSpot)
                .toList();

        // they should be distinct already...
        List<SpotId> allSpotIds = Stream.concat(publicSpotIds.stream(), personalSpotIdsStillNeeded.stream())
                .distinct()
                .toList();

        List<SpotMetadata> spotMetadataList = spotMetadataLookupPort.loadSpotMetadata(allSpotIds).stream()
                .map(spotMetadataPortMapper::toSpotMetadata)
                .toList();

        List<Spot> spots = Stream.concat(publicSpots.stream(), personalSpots.stream())
                .toList();


        return mapper.toSpotViewListResponse(spotPersonalizations, spots, spotMetadataList);
    }
}
