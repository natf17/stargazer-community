package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getspotviewusecase.SpotViewResponse;

import java.util.List;

public record SpotViewListResponse(List<SpotViewResponse> spots) { }
