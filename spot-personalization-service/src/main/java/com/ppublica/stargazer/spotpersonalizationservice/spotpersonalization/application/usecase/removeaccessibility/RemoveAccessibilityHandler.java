package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccessibility;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.Accessibility;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class RemoveAccessibilityHandler implements RemoveAccessibilityUseCase {
    private final SpotPersonalizationRepository repository;

    public RemoveAccessibilityHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(RemoveAccessibilityCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        Accessibility accessibility = Accessibility.valueOf(command.accessibility());

        spotPersonalization.removeAccessibility(accessibility);

        repository.save(spotPersonalization);
    }

}
