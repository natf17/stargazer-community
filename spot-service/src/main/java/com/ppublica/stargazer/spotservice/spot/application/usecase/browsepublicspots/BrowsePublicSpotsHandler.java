package com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots;

import com.ppublica.stargazer.spotservice.spot.application.mapper.SpotMapper;
import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrowsePublicSpotsHandler implements BrowsePublicSpotsUseCase {

    private final SpotRepository repository;
    private final SpotMapper spotMapper = new SpotMapper();

    public BrowsePublicSpotsHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SpotDto> handle(BrowsePublicSpotsQuery query) {
        return repository.findAllPublished().stream()
                .map(spotMapper::toSpotDto)
                .collect(Collectors.toList());
    }

}
