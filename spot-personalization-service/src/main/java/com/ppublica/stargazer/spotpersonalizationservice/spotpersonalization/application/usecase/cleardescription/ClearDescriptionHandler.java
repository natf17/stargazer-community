package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.cleardescription;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearDescriptionHandler implements ClearDescriptionUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearDescriptionHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearDescriptionCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearDescription();

        repository.save(spotPersonalization);
    }
}
