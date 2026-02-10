package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccessibility;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record RemoveAccessibilityCommand(SpotMetadataId id, String accessibility) {}
