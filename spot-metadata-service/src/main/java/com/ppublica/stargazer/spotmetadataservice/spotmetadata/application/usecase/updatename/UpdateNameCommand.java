package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.updatename;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record UpdateNameCommand(SpotMetadataId id, String name) { }
