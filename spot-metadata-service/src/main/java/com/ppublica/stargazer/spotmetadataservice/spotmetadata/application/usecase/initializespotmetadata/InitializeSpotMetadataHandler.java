package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataAlreadyExistsException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.mapper.SpotMetadataMapper;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLocationDto;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.CanonicalName;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.Coordinates;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializeSpotMetadataHandler implements InitializeSpotMetadataUseCase {

    private final SpotMetadataRepository spotMetadataRepository;
    private final SpotLookupPort spotLookupPort;
    private final SpotMetadataMapper mapper = new SpotMetadataMapper();

    public InitializeSpotMetadataHandler(SpotMetadataRepository spotMetadataRepository, SpotLookupPort spotLookupPort) {
        this.spotMetadataRepository = spotMetadataRepository;
        this.spotLookupPort = spotLookupPort;
    }

    @Override
    public SpotMetadataView handle(InitializeSpotMetadataCommand command) {
        SpotId spotId = command.spotId();
        String canonicalNameReceived = command.canonicalName();

        SpotLocationDto spotLocationDto = spotLookupPort.fetchLocation(spotId)
                .orElseThrow(SpotNotFoundException::new);


        spotMetadataRepository.findBySpotId(spotId)
                .ifPresent(spot -> {
                    throw new SpotMetadataAlreadyExistsException();
                });


        CanonicalName canonicalName = canonicalNameReceived == null || canonicalNameReceived.isEmpty() ?
                createFallBackCanonicalName(spotLocationDto) : CanonicalName.create(canonicalNameReceived);

        SpotMetadata spotMetadata = SpotMetadata.create(spotId, canonicalName);

        spotMetadataRepository.save(spotMetadata);

        return mapper.toSpotMetadataView(spotMetadata);


    }

    CanonicalName createFallBackCanonicalName(SpotLocationDto spotLocationDto) {
        Coordinates coordinates = Coordinates.create(
                spotLocationDto.coordinates().latitude(), spotLocationDto.coordinates().longitude());

        return CanonicalName.createFallback(coordinates);
    }

}
