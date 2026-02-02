package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

import java.util.List;

public interface GetSpotsByIdsUseCase {
    List<Spot> handle(GetSpotsByIdsQuery query);
}
