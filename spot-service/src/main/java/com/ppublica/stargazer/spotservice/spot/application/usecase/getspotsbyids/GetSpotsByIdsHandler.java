package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
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
        List<SpotId> spotIds = query.ids()
                .stream()
                .map(SpotId::of)
                .toList();

        return repository.findByIds(spotIds);
    }
}
