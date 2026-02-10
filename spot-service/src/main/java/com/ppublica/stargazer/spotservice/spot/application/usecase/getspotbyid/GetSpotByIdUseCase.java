package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotbyid;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

public interface GetSpotByIdUseCase {
    Spot execute(GetSpotByIdQuery query);
}
