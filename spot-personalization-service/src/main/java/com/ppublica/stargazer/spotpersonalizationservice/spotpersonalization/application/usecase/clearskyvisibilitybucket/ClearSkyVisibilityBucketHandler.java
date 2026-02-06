package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearskyvisibilitybucket;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearSkyVisibilityBucketHandler implements ClearSkyVisibilityBucketUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearSkyVisibilityBucketHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearSkyVisibilityBucketCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearSkyVisibilityBucket();

        repository.save(spotPersonalization);
    }
}
