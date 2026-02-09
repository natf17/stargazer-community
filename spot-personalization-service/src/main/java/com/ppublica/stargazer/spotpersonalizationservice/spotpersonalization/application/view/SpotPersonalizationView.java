package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view;

import java.util.Set;

public record SpotPersonalizationView(
        String description,
        String name,
        Set<String> accessPolicies,
        Set<String> accessibilities,
        Set<String> amenities,
        String terrainInclination,
        String groundSurfaceType,
        String skyVisibilityBucket,
        String visibilityCeiling,
        String globalHorizonVisibility,
        String bestHorizonDirection
) { }
