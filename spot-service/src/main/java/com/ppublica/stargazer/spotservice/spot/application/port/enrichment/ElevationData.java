package com.ppublica.stargazer.spotservice.spot.application.port.enrichment;

import com.ppublica.stargazer.spotservice.spot.domain.model.ElevationSrc;

public record ElevationData(double elevationMeters, ElevationSrc src) { }
