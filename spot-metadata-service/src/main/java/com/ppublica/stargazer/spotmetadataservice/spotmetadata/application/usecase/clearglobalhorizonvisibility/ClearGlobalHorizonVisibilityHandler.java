package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearglobalhorizonvisibility;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearGlobalHorizonVisibilityHandler implements ClearGlobalHorizonVisibilityUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearGlobalHorizonVisibilityHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearGlobalHorizonVisibilityCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearGlobalHorizonVisibility();

        spotMetadataRepository.save(spotMetadata);
    }
}
