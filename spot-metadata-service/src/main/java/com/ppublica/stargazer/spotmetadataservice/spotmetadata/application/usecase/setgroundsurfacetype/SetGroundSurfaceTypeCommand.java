package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setgroundsurfacetype;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetGroundSurfaceTypeCommand(SpotMetadataId id, String groundSurfaceType) {}
