package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewbyspot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.mapper.SpotMetadataMapper;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

@Component
public class GetSpotMetadataViewBySpotHandler implements GetSpotMetadataViewBySpotUseCase {

    private final SpotMetadataRepository repository;
    private final SpotLookupPort spotLookupPort;
    private final SpotMetadataMapper mapper = new SpotMetadataMapper();

    public GetSpotMetadataViewBySpotHandler(SpotMetadataRepository repository, SpotLookupPort spotLookupPort) {
        this.repository = repository;
        this.spotLookupPort = spotLookupPort;
    }

    @Override
    public SpotMetadataView execute(GetSpotMetadataViewBySpotQuery query) {
        SpotId spotId = SpotId.of(query.spotId());

        spotLookupPort.fetchLocation(spotId)
                .orElseThrow(SpotNotFoundException::new);

        return repository.findBySpotId(spotId)
                .map(mapper::toSpotMetadataView)
                .orElseThrow(SpotMetadataNotFoundException::new);

    }
}
