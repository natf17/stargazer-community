package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setvisibilityceiling;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetVisibilityCeilingCommand(SpotMetadataId id, double visibilityCeiling) { }
