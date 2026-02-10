package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccesspolicy;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.AccessPolicy;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class RemoveAccessPolicyHandler implements RemoveAccessPolicyUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public RemoveAccessPolicyHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(RemoveAccessPolicyCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        AccessPolicy accessPolicy = AccessPolicy.valueOf(command.accessPolicy());

        spotMetadata.removeAccessPolicy(accessPolicy);

        spotMetadataRepository.save(spotMetadata);

    }

}
