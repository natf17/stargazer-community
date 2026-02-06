package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccesspolicy;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.AccessPolicy;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class RemoveAccessPolicyHandler implements RemoveAccessPolicyUseCase {
    private final SpotPersonalizationRepository repository;

    public RemoveAccessPolicyHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(RemoveAccessPolicyCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        AccessPolicy accessPolicy = AccessPolicy.valueOf(command.accessPolicy());

        spotPersonalization.removeAccessPolicy(accessPolicy);

        repository.save(spotPersonalization);
    }

}
