package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.*;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;

import java.util.*;
import java.util.stream.Collectors;

public class SpotPersonalizationMapper {

    public SpotViewListResponse toSpotViewListResponse(List<SpotPersonalization> spotPersonalizations, List<Spot> spots, List<SpotMetadata> spotMetadataList) {
        Map<SpotId, SpotMetadata> spotMetadataMap = spotMetadataList.stream()
                .collect(Collectors.toMap(SpotMetadata::spotId, spotMetadata -> spotMetadata));
        Map<SpotId, SpotPersonalization> spotPersonalizationMap = spotPersonalizations.stream()
                .collect(Collectors.toMap(SpotPersonalization::spotId, spotPersonalization -> spotPersonalization));

        List<SpotViewResponse> spotViews = spots.stream()
                .map(spot -> {
                    return toSpotViewResponse(spot, spotMetadataMap.get(spot.spotId()), spotPersonalizationMap.get(spot.spotId()));
                })
                .toList();

        return new SpotViewListResponse(spotViews);

    }

    public SpotViewResponse toSpotViewResponse(Spot spot, SpotMetadata spotMetadata, SpotPersonalization spotPersonalization) {
        String name = null;
        String description = null;
        Set<String> accessPolicies = new HashSet<>();
        Set<String> accessibilities = new HashSet<>();
        Set<String> amenities = new HashSet<>();
        String terrainInclination = null;
        String groundSurfaceType = null;
        String skyVisibilityBucket = null;
        double visibilityCeiling = -1.0;
        String globalHorizonVisibility = null;
        String bestHorizonDirection = null;

        if(spotMetadata != null) {
            name = spotMetadata.name();
            description = spotMetadata.description().orElse(null);
            accessPolicies = Set.copyOf(spotMetadata.accessPolicies());
            accessibilities = Set.copyOf(spotMetadata.accessibilities());
            amenities = Set.copyOf(spotMetadata.amenities());
            terrainInclination = spotMetadata.terrainInclination().orElse(null);
            groundSurfaceType = spotMetadata.groundSurfaceType().orElse(null);
            skyVisibilityBucket = spotMetadata.skyVisibilityBucket().orElse(null);
            visibilityCeiling = spotMetadata.visibilityCeiling().orElse(-1.0);
            globalHorizonVisibility = spotMetadata.globalHorizonVisibility().orElse(null);
            bestHorizonDirection = spotMetadata.bestHorizonDirection().orElse(null);
        }

        return new SpotViewResponse(
                spot.spotId().value(),
                new CoordinatesView(spot.coordinates().latitude(), spot.coordinates().longitude()),
                new ElevationView(spot.elevation().meters(), spot.elevation().src()),
                new LightPollutionRatingView(spot.lightPollutionRating().bortleClass(),spot.lightPollutionRating().src()),
                name,
                description,
                accessPolicies,
                accessibilities,
                amenities,
                terrainInclination,
                groundSurfaceType,
                skyVisibilityBucket,
                visibilityCeiling,
                globalHorizonVisibility,
                bestHorizonDirection,
                spotPersonalization != null ? toSpotPersonalizationView(spotPersonalization) : null
        );

    }

    public SpotPersonalizationView toSpotPersonalizationView(SpotPersonalization spotPersonalization) {
        return new SpotPersonalizationView(
                spotPersonalization.name(),
                spotPersonalization.description().orElse(null),
                spotPersonalization.accessPolicies().stream().map(Enum::name).collect(Collectors.toSet()),
                spotPersonalization.accessibilities().stream().map(Enum::name).collect(Collectors.toSet()),
                spotPersonalization.amenities().stream().map(Enum::name).collect(Collectors.toSet()),
                spotPersonalization.terrainInclination().map(Enum::name).orElse(null),
                spotPersonalization.groundSurfaceType().map(Enum::name).orElse(null),
                spotPersonalization.skyVisibilityBucket().map(Enum::name).orElse(null),
                spotPersonalization.visibilityCeiling().orElse(-1.0),
                spotPersonalization.groundSurfaceType().map(Enum::name).orElse(null),
                spotPersonalization.bestHorizonDirection().map(Enum::name).orElse(null)
        );
    }


}
