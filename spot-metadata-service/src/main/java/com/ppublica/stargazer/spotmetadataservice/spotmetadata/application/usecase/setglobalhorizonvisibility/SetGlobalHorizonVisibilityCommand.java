package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setglobalhorizonvisibility;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetGlobalHorizonVisibilityCommand(SpotMetadataId id, String globalHorizonVisibility) { }
