package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataAlreadyExistsException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializeSpotMetadataHandler implements InitializeSpotMetadataUseCase {

    private final SpotMetadataRepository spotMetadataRepository;

    public InitializeSpotMetadataHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public SpotMetadata handle(InitializeSpotMetadataCommand command) {
        SpotId spotId = command.spotId();

        spotMetadataRepository.findBySpotId(spotId)
                .ifPresent(spot -> {
                    throw new SpotMetadataAlreadyExistsException();
                });

        SpotMetadata spotMetadata = SpotMetadata.create(spotId);

        return spotMetadataRepository.save(spotMetadata);


    }
}
