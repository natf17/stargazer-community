package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccesspolicy;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record AddAccessPolicyCommand(SpotPersonalizationId id, String accessPolicy) {}
