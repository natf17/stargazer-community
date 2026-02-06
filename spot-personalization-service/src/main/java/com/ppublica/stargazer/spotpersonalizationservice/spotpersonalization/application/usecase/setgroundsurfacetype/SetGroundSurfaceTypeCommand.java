package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setgroundsurfacetype;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record SetGroundSurfaceTypeCommand(SpotPersonalizationId id, String groundSurfaceType) {}
