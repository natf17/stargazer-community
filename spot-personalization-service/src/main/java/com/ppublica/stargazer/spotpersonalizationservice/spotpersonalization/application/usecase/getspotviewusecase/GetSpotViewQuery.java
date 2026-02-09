package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getspotviewusecase;

import java.util.Optional;

public record GetSpotViewQuery(String spotId, Optional<String> userId) { }
