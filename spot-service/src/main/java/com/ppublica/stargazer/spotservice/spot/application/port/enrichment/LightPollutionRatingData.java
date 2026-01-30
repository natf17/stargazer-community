package com.ppublica.stargazer.spotservice.spot.application.port.enrichment;

import com.ppublica.stargazer.spotservice.spot.domain.model.BortleClass;
import com.ppublica.stargazer.spotservice.spot.domain.model.LightPollutionSrc;

public record LightPollutionRatingData(BortleClass bortleClass, LightPollutionSrc src) { }
