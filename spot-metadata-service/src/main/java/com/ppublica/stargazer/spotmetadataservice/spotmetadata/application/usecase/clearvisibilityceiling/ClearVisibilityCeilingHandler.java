package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearvisibilityceiling;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearVisibilityCeilingHandler implements ClearVisibilityCeilingUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearVisibilityCeilingHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearVisibilityCeilingCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearVisibilityCeiling();

        spotMetadataRepository.save(spotMetadata);
    }
}
