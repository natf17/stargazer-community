package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setname;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetNameCommand(SpotMetadataId id, String name) { }
