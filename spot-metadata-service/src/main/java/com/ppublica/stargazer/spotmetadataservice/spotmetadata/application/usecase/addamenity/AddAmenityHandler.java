package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addamenity;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.Amenity;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

@Component
public class AddAmenityHandler implements AddAmenityUseCase {

    private final SpotMetadataRepository spotMetadataRepository;

    public AddAmenityHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }
    @Override
    public void handle(AddAmenityCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        Amenity amenity = Amenity.valueOf(command.amenity());

        spotMetadata.addAmenity(amenity);

        spotMetadataRepository.save(spotMetadata);

    }

}
