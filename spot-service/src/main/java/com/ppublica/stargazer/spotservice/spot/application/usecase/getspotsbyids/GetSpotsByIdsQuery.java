package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.List;

public record GetSpotsByIdsQuery(List<SpotId> ids) { }
