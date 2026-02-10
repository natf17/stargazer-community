package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record RemoveAmenityCommand(SpotMetadataId id, String amenity) {}
