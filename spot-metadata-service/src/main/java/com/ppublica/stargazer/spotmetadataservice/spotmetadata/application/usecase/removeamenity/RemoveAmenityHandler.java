package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.Amenity;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class RemoveAmenityHandler implements RemoveAmenityUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public RemoveAmenityHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }
    @Override
    public void handle(RemoveAmenityCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        Amenity amenity = Amenity.valueOf(command.amenity());

        spotMetadata.removeAmenity(amenity);

        spotMetadataRepository.save(spotMetadata);

    }
}
