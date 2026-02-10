package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setterraininclination;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetTerrainInclinationCommand(SpotMetadataId id, String terrainInclination) {}
