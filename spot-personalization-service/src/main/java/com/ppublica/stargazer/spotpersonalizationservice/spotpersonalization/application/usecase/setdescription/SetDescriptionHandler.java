package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setdescription;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetDescriptionHandler implements SetDescriptionUseCase {
    private final SpotPersonalizationRepository repository;

    public SetDescriptionHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetDescriptionCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        String description = command.description();

        spotPersonalization.description(description);

        repository.save(spotPersonalization);
    }

}
