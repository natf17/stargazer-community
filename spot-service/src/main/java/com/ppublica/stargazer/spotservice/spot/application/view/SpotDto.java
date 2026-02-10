package com.ppublica.stargazer.spotservice.spot.application.view;

import com.ppublica.stargazer.spotservice.api.dto.Coordinates;

public record SpotDto(String id, Coordinates coordinates, double elevationMeters, String bortleClass) {}
