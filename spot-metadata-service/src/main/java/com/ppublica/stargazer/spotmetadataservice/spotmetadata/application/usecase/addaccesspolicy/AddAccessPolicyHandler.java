package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccesspolicy;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.AccessPolicy;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

@Component
public class AddAccessPolicyHandler implements  AddAccessPolicyUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public AddAccessPolicyHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }
    @Override
    public void handle(AddAccessPolicyCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        AccessPolicy accessPolicy = AccessPolicy.valueOf(command.accessPolicy());

        spotMetadata.addAccessPolicy(accessPolicy);

        spotMetadataRepository.save(spotMetadata);

    }
}
