package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataAlreadyExistsException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializeSpotMetadataHandler implements InitializeSpotMetadataUseCase {

    private final SpotMetadataRepository spotMetadataRepository;
    private final SpotLookupPort spotLookupPort;

    public InitializeSpotMetadataHandler(SpotMetadataRepository spotMetadataRepository, SpotLookupPort spotLookupPort) {
        this.spotMetadataRepository = spotMetadataRepository;
        this.spotLookupPort = spotLookupPort;
    }

    @Override
    public SpotMetadata handle(InitializeSpotMetadataCommand command) {
        SpotId spotId = command.spotId();

        boolean doesSpotExist = spotLookupPort.spotExists(spotId);

        if(!doesSpotExist) {
            throw new SpotNotFoundException();
        }

        spotMetadataRepository.findBySpotId(spotId)
                .ifPresent(spot -> {
                    throw new SpotMetadataAlreadyExistsException();
                });

        SpotMetadata spotMetadata = SpotMetadata.create(spotId);

        return spotMetadataRepository.save(spotMetadata);


    }
}
