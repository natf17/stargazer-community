package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setdescription;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record SetDescriptionCommand(SpotPersonalizationId id, String description) { }
