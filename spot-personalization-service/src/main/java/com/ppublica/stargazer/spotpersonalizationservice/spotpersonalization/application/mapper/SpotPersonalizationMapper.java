package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.*;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;

import java.util.List;
import java.util.Map;
import java.util.Set;
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

    /*
     * spotPersonalization can be null
     */
    public SpotViewResponse toSpotViewResponse(Spot spot, SpotMetadata spotMetadata, SpotPersonalization spotPersonalization) {
        SpotPersonalizationView spotPersonalizationView = spotPersonalization == null ? null : toSpotPersonalizationView(spotPersonalization);


        return new SpotViewResponse(
                spot.spotId().value(),
                new CoordinatesView(spot.coordinates().latitude(), spot.coordinates().longitude()),
                new ElevationView(spot.elevation().meters(), spot.elevation().src()),
                new LightPollutionRatingView(spot.lightPollutionRating().bortleClass(),spot.lightPollutionRating().src()),
                spotMetadata.name(),
                spotMetadata.description().orElse(null),
                Set.copyOf(spotMetadata.accessPolicies()),
                Set.copyOf(spotMetadata.accessibilities()),
                Set.copyOf(spotMetadata.amenities()),
                spotMetadata.terrainInclination().orElse(null),
                spotMetadata.groundSurfaceType().orElse(null),
                spotMetadata.skyVisibilityBucket().orElse(null),
                spotMetadata.visibilityCeiling().orElse(null),
                spotMetadata.globalHorizonVisibility().orElse(null),
                spotMetadata.bestHorizonDirection().orElse(null),
                spotPersonalizationView
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
