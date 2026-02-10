package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.updatename;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.CanonicalName;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class UpdateNameHandler implements UpdateNameUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public UpdateNameHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(UpdateNameCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        CanonicalName name = CanonicalName.create(command.name());

        spotMetadata.setName(name);

        spotMetadataRepository.save(spotMetadata);

    }
}
