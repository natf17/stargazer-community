package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot;

public record SpotPortDto(String id, Coordinates coordinates, double elevationMeters, String bortleClass) {}