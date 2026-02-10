package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleardescription;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearDescriptionHandler implements ClearDescriptionUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearDescriptionHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearDescriptionCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearDescription();

        spotMetadataRepository.save(spotMetadata);
    }
}
