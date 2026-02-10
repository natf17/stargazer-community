package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setbesthorizondirection;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetBestHorizonDirectionCommand(SpotMetadataId id, String bestHorizonDirection) { }
