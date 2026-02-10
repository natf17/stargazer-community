package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

import java.util.Optional;
import java.util.Set;

public record SpotMetadata(
        SpotId spotId,
        SpotMetadataId spotMetadataId,
        Optional<String> description,
        String name,
        Set<String> accessPolicies,
        Set<String> accessibilities,
        Set<String> amenities,
        Optional<String> terrainInclination,
        Optional<String> groundSurfaceType,
        Optional<String> skyVisibilityBucket,
        Optional<Double> visibilityCeiling,
        Optional<String> globalHorizonVisibility,
        Optional<String> bestHorizonDirection
) { }
