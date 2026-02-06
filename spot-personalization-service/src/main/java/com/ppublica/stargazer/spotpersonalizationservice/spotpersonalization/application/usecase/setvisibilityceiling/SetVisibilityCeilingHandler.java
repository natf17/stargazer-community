package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setvisibilityceiling;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetVisibilityCeilingHandler implements SetVisibilityCeilingUseCase {
    private final SpotPersonalizationRepository repository;

    public SetVisibilityCeilingHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetVisibilityCeilingCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        Double visibilityCeiling = command.visibilityCeiling();

        spotPersonalization.visibilityCeiling(visibilityCeiling);

        repository.save(spotPersonalization);
    }

}
