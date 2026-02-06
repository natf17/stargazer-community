package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model;

public enum GlobalHorizonVisibility {
    OPEN, // (≥ 70% of azimuths have obstruction < 10°)
    MOSTLY_OPEN, // (40–70% of azimuths < 10°)
    PARTIALLY_BLOCKED, // (20–40% of azimuths < 10°)
    BLOCKED //(< 20% of azimuths < 10°)
}
