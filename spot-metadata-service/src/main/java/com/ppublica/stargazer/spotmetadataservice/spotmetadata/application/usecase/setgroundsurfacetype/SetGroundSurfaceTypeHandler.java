package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setgroundsurfacetype;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.GroundSurfaceType;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetGroundSurfaceTypeHandler implements SetGroundSurfaceTypeUseCase {

    private final SpotMetadataRepository spotMetadataRepository;

    public SetGroundSurfaceTypeHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetGroundSurfaceTypeCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        GroundSurfaceType groundSurfaceType = GroundSurfaceType.valueOf(command.groundSurfaceType());

        spotMetadata.groundSurfaceType(groundSurfaceType);

        spotMetadataRepository.save(spotMetadata);

    }
}
