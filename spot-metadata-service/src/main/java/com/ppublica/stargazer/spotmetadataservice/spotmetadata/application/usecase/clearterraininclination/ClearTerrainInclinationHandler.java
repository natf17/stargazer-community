package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearterraininclination;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearTerrainInclinationHandler implements ClearTerrainInclinationUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearTerrainInclinationHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearTerrainInclinationCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearTerrainInclination();

        spotMetadataRepository.save(spotMetadata);
    }
}
