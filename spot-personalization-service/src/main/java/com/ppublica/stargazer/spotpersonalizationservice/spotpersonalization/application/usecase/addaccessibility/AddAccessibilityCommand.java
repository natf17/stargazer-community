package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccessibility;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record AddAccessibilityCommand(SpotPersonalizationId id, String accessibility) {}
