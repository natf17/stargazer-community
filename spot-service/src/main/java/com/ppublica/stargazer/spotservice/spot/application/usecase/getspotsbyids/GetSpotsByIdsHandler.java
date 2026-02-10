package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotservice.spot.application.mapper.SpotMapper;
import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSpotsByIdsHandler implements GetSpotsByIdsUseCase {
    private final SpotRepository repository;
    private final SpotMapper spotMapper = new SpotMapper();

    public GetSpotsByIdsHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SpotDto> handle(GetSpotsByIdsQuery query) {
        List<SpotId> spotIds = query.ids()
                .stream()
                .map(SpotId::of)
                .toList();

        return repository.findByIds(spotIds).stream()
                .map(spotMapper::toSpotDto)
                .collect(Collectors.toList());
    }
}
