package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view;

import java.util.Set;

public record SpotViewResponse(String spotId,
                               CoordinatesView coordinates,
                               ElevationView elevation,
                               LightPollutionRatingView lightPollutionRating,
                               String name,
                               String description,
                               Set<String> accessPolicies,
                               Set<String> accessibilities,
                               Set<String> amenities,
                               String terrainInclination,
                               String groundSurfaceType,
                               String skyVisibilityBucket,
                               String visibilityCeiling,
                               String globalHorizonVisibility,
                               String bestHorizonDirection,
                               SpotPersonalizationView personalization) { }
