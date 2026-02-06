package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setterraininclination;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record SetTerrainInclinationCommand(SpotPersonalizationId id, String terrainInclination) {}
