package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setterraininclination;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.TerrainInclination;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetTerrainInclinationHandler implements SetTerrainInclinationUseCase {
    private final SpotPersonalizationRepository repository;

    public SetTerrainInclinationHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetTerrainInclinationCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        TerrainInclination terrainInclination = TerrainInclination.valueOf(command.terrainInclination());

        spotPersonalization.terrainInclination(terrainInclination);

        repository.save(spotPersonalization);
    }

}
