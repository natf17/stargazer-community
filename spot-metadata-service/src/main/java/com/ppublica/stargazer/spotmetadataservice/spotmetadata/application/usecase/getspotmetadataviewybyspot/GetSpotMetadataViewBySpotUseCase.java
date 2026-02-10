package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewybyspot;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;

public interface GetSpotMetadataViewBySpotUseCase {
    SpotMetadataView execute(GetSpotMetadataViewBySpotQuery query);
}
