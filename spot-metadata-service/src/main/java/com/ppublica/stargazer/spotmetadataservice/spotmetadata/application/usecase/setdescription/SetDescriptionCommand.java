package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setdescription;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetDescriptionCommand(SpotMetadataId id, String description) { }
