package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccessibility;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.Accessibility;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class AddAccessibilityHandler implements AddAccessibilityUseCase {

    private final SpotMetadataRepository spotMetadataRepository;

    public AddAccessibilityHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(AddAccessibilityCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        Accessibility accessibility = Accessibility.valueOf(command.accessibility());

        spotMetadata.addAccessibility(accessibility);

        spotMetadataRepository.save(spotMetadata);
    }
}
