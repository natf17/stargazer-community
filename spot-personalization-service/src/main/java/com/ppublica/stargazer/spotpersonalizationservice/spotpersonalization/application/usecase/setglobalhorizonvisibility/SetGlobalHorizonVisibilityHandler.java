package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setglobalhorizonvisibility;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.GlobalHorizonVisibility;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetGlobalHorizonVisibilityHandler implements SetGlobalHorizonVisibilityUseCase {
    private final SpotPersonalizationRepository repository;

    public SetGlobalHorizonVisibilityHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetGlobalHorizonVisibilityCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        GlobalHorizonVisibility globalHorizonVisibility = GlobalHorizonVisibility.valueOf(command.globalHorizonVisibility());

        spotPersonalization.globalHorizonVisibility(globalHorizonVisibility);

        repository.save(spotPersonalization);
    }

}
