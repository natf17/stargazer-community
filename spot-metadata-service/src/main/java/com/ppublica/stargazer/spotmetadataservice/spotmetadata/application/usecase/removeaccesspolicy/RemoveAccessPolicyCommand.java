package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccesspolicy;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record RemoveAccessPolicyCommand(SpotMetadataId id, String accessPolicy) {}
