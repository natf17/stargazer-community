package com.ppublica.stargazer.spotservice.spot.application.usecase.getspotbyid;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotservice.spot.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

@Component
public class GetSpotByIdHandler implements GetSpotByIdUseCase {
    private final SpotRepository repository;

    public GetSpotByIdHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public Spot execute(GetSpotByIdQuery query) {
        SpotId spotId = SpotId.of(query.id());

        return repository.findById(spotId).orElseThrow(SpotNotFoundException::new);
    }
}
