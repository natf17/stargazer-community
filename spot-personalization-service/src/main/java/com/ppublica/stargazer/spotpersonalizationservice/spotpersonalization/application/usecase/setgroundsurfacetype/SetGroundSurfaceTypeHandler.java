package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setgroundsurfacetype;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.GroundSurfaceType;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetGroundSurfaceTypeHandler implements SetGroundSurfaceTypeUseCase {

    private final SpotPersonalizationRepository repository;

    public SetGroundSurfaceTypeHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetGroundSurfaceTypeCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        GroundSurfaceType groundSurfaceType = GroundSurfaceType.valueOf(command.groundSurfaceType());

        spotPersonalization.groundSurfaceType(groundSurfaceType);

        repository.save(spotPersonalization);
    }

}
