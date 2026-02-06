package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccessibility;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record RemoveAccessibilityCommand(SpotPersonalizationId id, String accessibility) {}
