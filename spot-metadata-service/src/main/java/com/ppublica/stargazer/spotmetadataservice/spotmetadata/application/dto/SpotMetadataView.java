package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto;

import java.util.Set;

public record SpotMetadataView(String id,
                               String spotId,
                               String description,
                               String name,
                               Set<String> accessPolicies,
                               Set<String> accessibilities,
                               Set<String> amenities,
                               String terrainInclination,
                               String groundSurfaceType,
                               String skyVisibilityBucket,
                               double visibilityCeiling,
                               String globalHorizonVisibility,
                               String bestHorizonDirection) {}
