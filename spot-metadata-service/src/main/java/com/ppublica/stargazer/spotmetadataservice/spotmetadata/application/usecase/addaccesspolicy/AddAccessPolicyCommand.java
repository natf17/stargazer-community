package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccesspolicy;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record AddAccessPolicyCommand(SpotMetadataId id, String accessPolicy) {}
