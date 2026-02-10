package com.ppublica.stargazer.spotservice.spot.application.usecase.publishspot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotservice.spot.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

@Component
public class PublishSpotHandler implements PublishSpotUseCase {

    private final SpotRepository repository;

    public PublishSpotHandler(SpotRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(PublishSpotCommand command) {
        SpotId spotId = SpotId.of(command.id());

        Spot spot = repository.findById(spotId)
                .orElseThrow(SpotNotFoundException::new);

        spot.makePublic();

        repository.save(spot);

    }

}
