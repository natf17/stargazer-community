package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.mapper;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.CanonicalDescription;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.VisibilityCeiling;

import java.util.stream.Collectors;

public class SpotMetadataMapper {

    public SpotMetadataView toSpotMetadataView(SpotMetadata spotMetadata) {
        return new SpotMetadataView(
                spotMetadata.id().value(),
                spotMetadata.spotId().value(),
                spotMetadata.description().map(CanonicalDescription::value).orElse(null),
                spotMetadata.name().value(),
                spotMetadata.accessPolicies().stream().map(Enum::name).collect(Collectors.toSet()),
                spotMetadata.accessibilities().stream().map(Enum::name).collect(Collectors.toSet()),
                spotMetadata.amenities().stream().map(Enum::name).collect(Collectors.toSet()),
                spotMetadata.terrainInclination().map(Enum::name).orElse(null),
                spotMetadata.groundSurfaceType().map(Enum::name).orElse(null),
                spotMetadata.skyVisibilityBucket().map(Enum::name).orElse(null),
                spotMetadata.visibilityCeiling().map(VisibilityCeiling::degrees).orElse(-1.0),
                spotMetadata.globalHorizonVisibility().map(Enum::name).orElse(null),
                spotMetadata.bestHorizonDirection().map(Enum::name).orElse(null));
    }
}
