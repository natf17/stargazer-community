package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setterraininclination;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetTerrainInclinationCommand(SpotMetadataId id, String terrainInclination) {}
