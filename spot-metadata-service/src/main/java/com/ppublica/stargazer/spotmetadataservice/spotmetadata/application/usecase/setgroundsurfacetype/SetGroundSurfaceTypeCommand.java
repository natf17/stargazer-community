package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setgroundsurfacetype;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetGroundSurfaceTypeCommand(SpotMetadataId id, String groundSurfaceType) {}
