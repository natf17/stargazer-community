package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.cleargroundsurfacetype;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearGroundSurfaceTypeHandler implements ClearGroundSurfaceTypeUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearGroundSurfaceTypeHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearGroundSurfaceTypeCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearGroundSurfaceType();

        repository.save(spotPersonalization);
    }
}
