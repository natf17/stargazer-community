package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setdescription;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.CanonicalDescription;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetDescriptionHandler implements SetDescriptionUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public SetDescriptionHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetDescriptionCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        CanonicalDescription canonicalDescription = CanonicalDescription.create(command.description());

        spotMetadata.description(canonicalDescription);

        spotMetadataRepository.save(spotMetadata);

    }
}
