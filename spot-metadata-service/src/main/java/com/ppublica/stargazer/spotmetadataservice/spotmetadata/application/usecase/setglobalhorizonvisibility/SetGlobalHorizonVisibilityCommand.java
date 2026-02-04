package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setglobalhorizonvisibility;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetGlobalHorizonVisibilityCommand(SpotMetadataId id, String globalHorizonVisibility) { }
