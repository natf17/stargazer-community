package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getspotviewusecase;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewResponse;

public interface GetSpotViewUseCase {
    SpotViewResponse execute(GetSpotViewQuery query);
}
