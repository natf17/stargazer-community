package com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrowsePublicSpotsHandler implements BrowsePublicSpotsUseCase {

    private final SpotRepository repository;

    public BrowsePublicSpotsHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Spot> handle(BrowsePublicSpotsQuery query) {
        return repository.findAllPublished();
    }

}
