package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setbesthorizondirection;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.BestHorizonDirection;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class SetBestHorizonDirectionHandler implements SetBestHorizonDirectionUseCase {
    private final SpotPersonalizationRepository repository;

    public SetBestHorizonDirectionHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(SetBestHorizonDirectionCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        BestHorizonDirection bestHorizonDirection = BestHorizonDirection.valueOf(command.bestHorizonDirection());

        spotPersonalization.bestHorizonDirection(bestHorizonDirection);

        repository.save(spotPersonalization);
    }

}
