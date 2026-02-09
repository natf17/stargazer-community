package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallspotviews;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewListResponse;

public interface GetAllSpotViewsUseCase {
    SpotViewListResponse execute(GetAllSpotViewsQuery query);
}
