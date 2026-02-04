package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearterraininclination;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record ClearTerrainInclinationCommand(SpotMetadataId id, String terrainInclination) {}
