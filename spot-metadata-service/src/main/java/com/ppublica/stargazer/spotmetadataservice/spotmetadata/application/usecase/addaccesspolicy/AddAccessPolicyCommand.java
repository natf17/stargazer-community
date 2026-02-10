package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccesspolicy;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record AddAccessPolicyCommand(SpotMetadataId id, String accessPolicy) {}
