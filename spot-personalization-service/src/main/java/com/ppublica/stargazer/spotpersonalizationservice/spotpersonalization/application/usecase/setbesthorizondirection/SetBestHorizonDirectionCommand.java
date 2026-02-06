package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setbesthorizondirection;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record SetBestHorizonDirectionCommand(SpotPersonalizationId id, String bestHorizonDirection) { }
