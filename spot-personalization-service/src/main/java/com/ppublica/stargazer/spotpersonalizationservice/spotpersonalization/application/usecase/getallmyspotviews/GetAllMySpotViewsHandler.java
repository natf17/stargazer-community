package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallmyspotviews;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.UserNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotMetadataPortMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPersonalizationMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPortMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotPortDto;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata.SpotMetadataPortDto;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata.SpotMetadataLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.user.UserLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewListResponse;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllMySpotViewsHandler implements GetAllMySpotViewsUseCase {

    private final SpotPersonalizationRepository repository;
    private final UserLookupPort userLookupPort;
    private final SpotLookupPort spotLookupPort;
    private final SpotMetadataLookupPort spotMetadataLookupPort;
    private final SpotPersonalizationMapper mapper = new SpotPersonalizationMapper();
    private final SpotPortMapper spotPortMapper = new SpotPortMapper();
    private final SpotMetadataPortMapper spotMetadataPortMapper = new SpotMetadataPortMapper();

    public GetAllMySpotViewsHandler(SpotPersonalizationRepository repository,
                                    UserLookupPort userLookupPort,
                                    SpotLookupPort spotLookupPort,
                                    SpotMetadataLookupPort spotMetadataLookupPort) {
        this.repository = repository;
        this.userLookupPort = userLookupPort;
        this.spotLookupPort = spotLookupPort;
        this.spotMetadataLookupPort = spotMetadataLookupPort;
    }

    @Override
    public SpotViewListResponse execute(GetAllMySpotViewsQuery query) {
        UserId userId = UserId.of(query.userId());

        if(!userLookupPort.doesUserExist(userId)) {
            throw new UserNotFoundException();
        }

        List<SpotPersonalization> spotPersonalizations = repository.findByUserId(userId);

        List<SpotId> spotIds = spotPersonalizations.stream().map(SpotPersonalization::spotId).toList();

        List<SpotPortDto> spotsFound = spotLookupPort.loadSpots(spotIds);
        List<Spot> spots = spotsFound.stream()
                .map(spotPortMapper::toSpot)
                .toList();

        List<SpotMetadataPortDto> spotMetadataFound = spotMetadataLookupPort.loadSpotMetadata(spotIds);

        List<SpotMetadata> spotMetadata = spotMetadataFound.stream()
                .map(spotMetadataPortMapper::toSpotMetadata)
                .toList();

        return mapper.toSpotViewListResponse(spotPersonalizations, spots, spotMetadata);
    }

}
