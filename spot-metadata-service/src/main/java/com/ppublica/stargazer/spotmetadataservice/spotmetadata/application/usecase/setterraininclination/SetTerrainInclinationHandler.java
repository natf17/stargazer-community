package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setterraininclination;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.TerrainInclination;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetTerrainInclinationHandler implements SetTerrainInclinationUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public SetTerrainInclinationHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetTerrainInclinationCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        TerrainInclination terrainInclination = TerrainInclination.valueOf(command.terrainInclination());

        spotMetadata.terrainInclination(terrainInclination);

        spotMetadataRepository.save(spotMetadata);

    }


}
