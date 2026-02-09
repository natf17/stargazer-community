package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallmyspotviews;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewListResponse;

public interface GetAllMySpotViewsUseCase {
    SpotViewListResponse execute(GetAllMySpotViewsQuery query);
}
