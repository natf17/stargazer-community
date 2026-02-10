package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setskyvisibilitybucket;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;

public record SetSkyVisibilityBucketCommand(SpotMetadataId id, String skyVisibilityBucket) {}
