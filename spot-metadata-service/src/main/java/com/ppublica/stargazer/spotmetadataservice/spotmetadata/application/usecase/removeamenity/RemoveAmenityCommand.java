package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record RemoveAmenityCommand(SpotMetadataId id, String amenity) {}
