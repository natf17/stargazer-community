package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewsbyspotids;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataListResponse;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.mapper.SpotMetadataMapper;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSpotMetadataViewsBySpotIdsHandler implements GetSpotMetadataViewsBySpotIdsUseCase {


    private final SpotMetadataRepository repository;
    private final SpotMetadataMapper mapper = new SpotMetadataMapper();

    public GetSpotMetadataViewsBySpotIdsHandler(SpotMetadataRepository repository) {
        this.repository = repository;
    }

    @Override
    public SpotMetadataListResponse execute(GetSpotMetadataViewsBySpotIdsQuery query) {
        List<SpotId> spotIds = query.spotIds().stream().map(SpotId::of).toList();

        List<SpotMetadataView> views =  repository.findBySpotIds(spotIds).stream()
                .map(mapper::toSpotMetadataView)
                .toList();

        return new SpotMetadataListResponse(views);


    }
}
