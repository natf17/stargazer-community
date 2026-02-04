package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setdescription;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetDescriptionCommand(SpotMetadataId id, String description) { }
