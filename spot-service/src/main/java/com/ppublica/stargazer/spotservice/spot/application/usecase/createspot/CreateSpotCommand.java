package com.ppublica.stargazer.spotservice.spot.application.usecase.createspot;

import com.ppublica.stargazer.spotservice.spot.domain.model.Location;

public record CreateSpotCommand(Location location) { }
