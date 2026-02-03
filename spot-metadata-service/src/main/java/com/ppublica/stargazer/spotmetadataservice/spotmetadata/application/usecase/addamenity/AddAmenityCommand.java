package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addamenity;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record AddAmenityCommand(SpotMetadataId id, String amenity) {}
