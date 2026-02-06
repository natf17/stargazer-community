package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccesspolicy;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.AccessPolicy;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;
import org.springframework.stereotype.Component;

@Component
public class AddAccessPolicyHandler implements AddAccessPolicyUseCase {
    private final SpotPersonalizationRepository repository;

    public AddAccessPolicyHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(AddAccessPolicyCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        AccessPolicy accessPolicy = AccessPolicy.valueOf(command.accessPolicy());

        spotPersonalization.addAccessPolicy(accessPolicy);

        repository.save(spotPersonalization);

    }
}
