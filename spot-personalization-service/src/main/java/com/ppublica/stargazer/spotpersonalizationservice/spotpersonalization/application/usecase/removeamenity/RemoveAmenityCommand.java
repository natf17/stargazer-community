package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeamenity;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record RemoveAmenityCommand(SpotPersonalizationId id, String amenity) {}
