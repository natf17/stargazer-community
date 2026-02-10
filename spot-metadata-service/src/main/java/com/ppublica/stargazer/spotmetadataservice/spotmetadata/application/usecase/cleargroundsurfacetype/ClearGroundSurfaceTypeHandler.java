package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleargroundsurfacetype;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearGroundSurfaceTypeHandler implements ClearGroundSurfaceTypeUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearGroundSurfaceTypeHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearGroundSurfaceTypeCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearGroundSurfaceType();

        spotMetadataRepository.save(spotMetadata);
    }
}
