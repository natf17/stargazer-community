package com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin;

import com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots.BrowsePublicSpotsHandler;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrowseAllSpotsAdminHandler implements BrowseAllSpotsAdminUseCase {
    private final SpotRepository repository;

    public BrowseAllSpotsAdminHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Spot> handle(BrowseAllSpotsAdminQuery query) {
        return repository.findAll();
    }
}
