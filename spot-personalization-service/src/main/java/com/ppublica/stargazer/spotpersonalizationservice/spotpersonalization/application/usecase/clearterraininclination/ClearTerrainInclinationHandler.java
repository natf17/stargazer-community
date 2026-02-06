package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearterraininclination;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearTerrainInclinationHandler implements ClearTerrainInclinationUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearTerrainInclinationHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearTerrainInclinationCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearTerrainInclination();

        repository.save(spotPersonalization);
    }
}
