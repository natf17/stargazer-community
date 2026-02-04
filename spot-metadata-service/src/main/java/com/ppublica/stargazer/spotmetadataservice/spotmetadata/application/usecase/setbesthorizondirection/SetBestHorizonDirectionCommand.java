package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setbesthorizondirection;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetBestHorizonDirectionCommand(SpotMetadataId id, String bestHorizonDirection) { }
