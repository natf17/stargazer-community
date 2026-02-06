package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.updatename;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class UpdateNameHandler implements UpdateNameUseCase {
    private final SpotPersonalizationRepository repository;

    public UpdateNameHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(UpdateNameCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        String name = command.name();

        spotPersonalization.updateName(name);

        repository.save(spotPersonalization);
    }

}
