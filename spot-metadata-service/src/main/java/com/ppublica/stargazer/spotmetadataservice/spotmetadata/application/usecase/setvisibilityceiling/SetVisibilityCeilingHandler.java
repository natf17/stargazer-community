package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setvisibilityceiling;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.VisibilityCeiling;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetVisibilityCeilingHandler implements SetVisibilityCeilingUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public SetVisibilityCeilingHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetVisibilityCeilingCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        double visibilityCeilingCommandDegrees = command.visibilityCeiling();

        spotMetadata.visibilityCeiling(new VisibilityCeiling(visibilityCeilingCommandDegrees));

        spotMetadataRepository.save(spotMetadata);
    }
}
