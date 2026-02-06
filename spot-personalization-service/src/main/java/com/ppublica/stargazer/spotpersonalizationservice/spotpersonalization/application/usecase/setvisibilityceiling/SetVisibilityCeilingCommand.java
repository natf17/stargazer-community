package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setvisibilityceiling;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record SetVisibilityCeilingCommand(SpotPersonalizationId id, double visibilityCeiling) { }
