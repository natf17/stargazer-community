package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setvisibilityceiling;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetVisibilityCeilingCommand(SpotMetadataId id, double visibilityCeiling) { }
