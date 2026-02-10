package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.updatename;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record UpdateNameCommand(SpotMetadataId id, String name) { }
