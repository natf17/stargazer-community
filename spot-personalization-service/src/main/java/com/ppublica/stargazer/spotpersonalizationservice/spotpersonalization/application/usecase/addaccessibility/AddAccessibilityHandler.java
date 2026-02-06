package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccessibility;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.Accessibility;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class AddAccessibilityHandler implements AddAccessibilityUseCase {

    private final SpotPersonalizationRepository repository;

    public AddAccessibilityHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(AddAccessibilityCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        Accessibility accessibility = Accessibility.valueOf(command.accessibility());

        spotPersonalization.addAccessibility(accessibility);

        repository.save(spotPersonalization);
    }
}
