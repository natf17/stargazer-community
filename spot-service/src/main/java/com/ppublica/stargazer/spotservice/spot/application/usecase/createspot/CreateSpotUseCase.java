package com.ppublica.stargazer.spotservice.spot.application.usecase.createspot;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

public interface CreateSpotUseCase {
    Spot handle(CreateSpotCommand createSpotCommand);
}
