package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addamenity;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record AddAmenityCommand(SpotMetadataId id, String amenity) {}
