package com.ppublica.stargazer.spotservice.spot.application.usecase.createspot;

import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;

public interface CreateSpotUseCase {
    SpotDto handle(CreateSpotCommand createSpotCommand);
}
