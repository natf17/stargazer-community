package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearglobalhorizonvisibility;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearGlobalHorizonVisibilityHandler implements ClearGlobalHorizonVisibilityUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearGlobalHorizonVisibilityHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearGlobalHorizonVisibilityCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearGlobalHorizonVisibility();

        repository.save(spotPersonalization);
    }
}
