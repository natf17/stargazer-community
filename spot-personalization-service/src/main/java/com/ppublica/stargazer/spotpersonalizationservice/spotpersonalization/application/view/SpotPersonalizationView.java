package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view;

import java.util.Set;

public record SpotPersonalizationView(
        String name,
        String description,
        Set<String> accessPolicies,
        Set<String> accessibilities,
        Set<String> amenities,
        String terrainInclination,
        String groundSurfaceType,
        String skyVisibilityBucket,
        double visibilityCeiling,
        String globalHorizonVisibility,
        String bestHorizonDirection
) { }
