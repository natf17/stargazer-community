package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.updatename;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record UpdateNameCommand(SpotPersonalizationId id, String name) { }
