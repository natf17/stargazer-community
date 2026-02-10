package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata;

import java.util.Set;

public record SpotMetadataPortDto(String id,
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
                                  String bestHorizonDirection) {
}
