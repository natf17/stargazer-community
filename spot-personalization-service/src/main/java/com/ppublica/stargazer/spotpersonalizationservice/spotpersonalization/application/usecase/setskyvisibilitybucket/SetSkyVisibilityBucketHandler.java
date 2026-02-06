package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setskyvisibilitybucket;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SkyVisibilityBucket;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetSkyVisibilityBucketHandler implements SetSkyVisibilityBucketUseCase{
    private final SpotPersonalizationRepository repository;

    public SetSkyVisibilityBucketHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetSkyVisibilityBucketCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        SkyVisibilityBucket skyVisibilityBucket = SkyVisibilityBucket.valueOf(command.skyVisibilityBucket());

        spotPersonalization.skyVisibilityBucket(skyVisibilityBucket);

        repository.save(spotPersonalization);
    }

}
