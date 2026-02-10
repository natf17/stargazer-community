package com.ppublica.stargazer.spotservice.spot.application.usecase.createspot;

import com.ppublica.stargazer.spotservice.spot.application.exception.SpotAlreadyExistsException;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.ElevationData;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.ElevationEnrichmentPort;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.LightPollutionRatingData;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.LightPollutionRatingEnrichmentPort;
import com.ppublica.stargazer.spotservice.spot.domain.model.*;
import com.ppublica.stargazer.spotservice.spot.domain.repository.SpotRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateSpotHandler implements CreateSpotUseCase {
    private final SpotRepository spotRepository;
    private final ElevationEnrichmentPort elevationEnrichmentPort;
    private final LightPollutionRatingEnrichmentPort lightPollutionRatingEnrichmentPort;

    public CreateSpotHandler(SpotRepository spotRepository, ElevationEnrichmentPort elevationEnrichmentPort,
                             LightPollutionRatingEnrichmentPort lightPollutionRatingEnrichmentPort) {
        this.spotRepository = spotRepository;
        this.elevationEnrichmentPort = elevationEnrichmentPort;
        this.lightPollutionRatingEnrichmentPort = lightPollutionRatingEnrichmentPort;
    }

    @Override
    public Spot handle(CreateSpotCommand createSpotCommand) {
        Location location = Location.create(createSpotCommand.latutide(), createSpotCommand.longitude());

        Optional<Spot> spotOpt = spotRepository.findByLocation(location);

        spotOpt.ifPresent(spot -> {
            throw new SpotAlreadyExistsException();
        });

        Spot spot = Spot.create(location);

        ElevationData elevation = elevationEnrichmentPort.fetchElevation(spot.location());

        spot.updateElevation(new ElevationUpdate(elevation.elevationMeters(), elevation.src()));


        // light pollution rating might be unavailable...
        LightPollutionRatingData lightPollutionRating =
                lightPollutionRatingEnrichmentPort.fetchLightPollutionRating(spot.location());

        spot.updateLightPollutionRating(
                new LightPollutionRatingUpdate(lightPollutionRating.bortleClass(), lightPollutionRating.src())
        );


        spotRepository.save(spot);

        return spot;

    }

}
