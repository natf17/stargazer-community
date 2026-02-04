package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccessibility;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record AddAccessibilityCommand(SpotMetadataId id, String accessibility) {}
