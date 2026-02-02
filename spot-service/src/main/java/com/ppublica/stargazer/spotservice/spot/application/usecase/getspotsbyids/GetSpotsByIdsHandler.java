package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetSpotsByIdsHandler implements GetSpotsByIdsUseCase {
    private final SpotRepository repository;

    public GetSpotsByIdsHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Spot> handle(GetSpotsByIdsQuery query) {

        return repository.findByIds(query.ids());
    }
}
