package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearbesthorizondirection;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearBestHorizonDirectionHandler implements ClearBestHorizonDirectionUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearBestHorizonDirectionHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearBestHorizonDirectionCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearBestHorizonDirection();

        spotMetadataRepository.save(spotMetadata);
    }
}
