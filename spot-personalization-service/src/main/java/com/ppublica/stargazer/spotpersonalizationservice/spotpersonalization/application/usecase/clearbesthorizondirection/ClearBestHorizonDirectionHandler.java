package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearbesthorizondirection;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class ClearBestHorizonDirectionHandler implements ClearBestHorizonDirectionUseCase {
    private final SpotPersonalizationRepository repository;

    public ClearBestHorizonDirectionHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(ClearBestHorizonDirectionCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        spotPersonalization.clearBestHorizonDirection();

        repository.save(spotPersonalization);
    }
}
