package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewsbyspotids;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataListResponse;

public interface GetSpotMetadataViewsBySpotIdsUseCase {
    SpotMetadataListResponse execute(GetSpotMetadataViewsBySpotIdsQuery query);
}
