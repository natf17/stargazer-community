package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearvisibilityceiling;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearVisibilityCeilingHandler implements ClearVisibilityCeilingUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearVisibilityCeilingHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearVisibilityCeilingCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearVisibilityCeiling();

        repository.save(spotPersonalization);
    }
}
