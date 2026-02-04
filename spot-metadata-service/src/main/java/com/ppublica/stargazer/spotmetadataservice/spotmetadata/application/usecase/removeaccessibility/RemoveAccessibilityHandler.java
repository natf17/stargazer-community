package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccessibility;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.Accessibility;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class RemoveAccessibilityHandler implements RemoveAccessibilityUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public RemoveAccessibilityHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(RemoveAccessibilityCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        Accessibility accessibility = Accessibility.valueOf(command.accessibility());

        spotMetadata.removeAccessibility(accessibility);

        spotMetadataRepository.save(spotMetadata);
    }

}
