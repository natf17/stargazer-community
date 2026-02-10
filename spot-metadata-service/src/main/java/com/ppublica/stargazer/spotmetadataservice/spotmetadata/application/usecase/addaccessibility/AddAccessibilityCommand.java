package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccessibility;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record AddAccessibilityCommand(SpotMetadataId id, String accessibility) {}
