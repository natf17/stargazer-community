package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view;

import java.util.Optional;
import java.util.Set;

public record SpotView(String spotId,
                       CoordinatesView coordinates,
                       ElevationView elevation,
                       LightPollutionRatingView lightPollutionRating,
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
                       String bestHorizonDirection,
                       SpotPersonalizationView personalization) { }
