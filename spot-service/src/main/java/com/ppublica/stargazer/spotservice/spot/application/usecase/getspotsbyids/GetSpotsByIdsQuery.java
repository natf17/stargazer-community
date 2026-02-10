package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import java.util.List;

public record GetSpotsByIdsQuery(List<String> ids) { }
