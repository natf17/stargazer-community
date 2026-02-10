package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata.SpotMetadataPortDto;

import java.util.Optional;
import java.util.Set;

public class SpotMetadataPortMapper {
    public SpotMetadata toSpotMetadata(SpotMetadataPortDto spotMetadataPortDto) {
        return new SpotMetadata(SpotId.of(spotMetadataPortDto.spotId()),
                SpotMetadataId.of(spotMetadataPortDto.id()),
                Optional.of(spotMetadataPortDto.description()),
                spotMetadataPortDto.name(),
                Set.copyOf(spotMetadataPortDto.accessPolicies()),
                Set.copyOf(spotMetadataPortDto.accessibilities()),
                Set.copyOf(spotMetadataPortDto.amenities()),
                Optional.of(spotMetadataPortDto.terrainInclination()),
                Optional.of(spotMetadataPortDto.groundSurfaceType()),
                Optional.of(spotMetadataPortDto.skyVisibilityBucket()),
                Optional.of(spotMetadataPortDto.visibilityCeiling()),
                Optional.of(spotMetadataPortDto.globalHorizonVisibility()),
                Optional.of(spotMetadataPortDto.bestHorizonDirection())
                );
    }
}
