package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.infrastructure.spot;

public record SpotResponse(String id, CoordinatesResponse coordinates, double elevationMeters, String bortleClass) { }
