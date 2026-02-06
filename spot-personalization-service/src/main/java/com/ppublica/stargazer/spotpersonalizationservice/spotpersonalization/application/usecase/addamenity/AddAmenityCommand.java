package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addamenity;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record AddAmenityCommand(SpotPersonalizationId id, String amenity) {}
