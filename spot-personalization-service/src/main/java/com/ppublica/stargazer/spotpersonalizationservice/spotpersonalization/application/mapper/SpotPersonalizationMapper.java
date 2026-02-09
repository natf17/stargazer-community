package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spotmetadata.SpotMetadata;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewListResponse;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;

import java.util.List;

public class SpotPersonalizationMapper {

    public SpotViewListResponse toSpotViewListResponse(List<SpotPersonalization> spotPersonalizations, List<Spot> spots, List<SpotMetadata> spotMetadataList) {
        throw new UnsupportedOperationException();
    }

}
