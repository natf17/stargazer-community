package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setskyvisibilitybucket;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

public record SetSkyVisibilityBucketCommand(SpotPersonalizationId id, String skyVisibilityBucket) {}
