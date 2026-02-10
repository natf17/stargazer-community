package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;

import java.util.List;

public interface GetSpotsByIdsUseCase {
    List<SpotDto> handle(GetSpotsByIdsQuery query);
}
