package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setskyvisibilitybucket;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;

public record SetSkyVisibilityBucketCommand(SpotMetadataId id, String skyVisibilityBucket) {}
