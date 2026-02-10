package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getspotviewusecase;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.UserNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotMetadataPortMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPersonalizationMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPortMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata.SpotMetadataLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.user.UserLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewResponse;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

import java.util.Optional;

public class GetSpotViewHandler implements GetSpotViewUseCase {
    private final SpotPersonalizationRepository repository;
    private final UserLookupPort userLookupPort;
    private final SpotLookupPort spotLookupPort;
    private final SpotMetadataLookupPort spotMetadataLookupPort;
    private final SpotPersonalizationMapper mapper = new SpotPersonalizationMapper();
    private final SpotPortMapper spotPortMapper = new SpotPortMapper();
    private final SpotMetadataPortMapper spotMetadataPortMapper = new SpotMetadataPortMapper();

    public GetSpotViewHandler(SpotPersonalizationRepository repository,
                              UserLookupPort userLookupPort,
                              SpotLookupPort spotLookupPort,
                              SpotMetadataLookupPort spotMetadataLookupPort) {
        this.repository = repository;
        this.userLookupPort = userLookupPort;
        this.spotLookupPort = spotLookupPort;
        this.spotMetadataLookupPort = spotMetadataLookupPort;
    }

    @Override
    public SpotViewResponse execute(GetSpotViewQuery query) {
        SpotId spotId = SpotId.of(query.spotId());
        SpotPersonalization spotPersonalization = null;

        if(query.userId().isPresent()) {
            UserId userId = UserId.of(query.userId().get());

            if(!userLookupPort.doesUserExist(userId)) {
                throw new UserNotFoundException();
            }

            spotPersonalization = repository.findById(new SpotPersonalizationId(userId, spotId)).orElse(null);

        }

        Spot spot = spotLookupPort.loadSpot(spotId)
                .map(spotPortMapper::toSpot)
                .orElseThrow(SpotNotFoundException::new);


        SpotMetadata spotMetadata = spotMetadataLookupPort.loadSpotMetadata(spotId)
                .map(spotMetadataPortMapper::toSpotMetadata).orElse(null);

        return mapper.toSpotViewResponse(spot, spotMetadata, spotPersonalization);
    }
}
