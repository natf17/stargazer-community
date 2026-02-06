package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccesspolicy;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record RemoveAccessPolicyCommand(SpotPersonalizationId id, String accessPolicy) {}
