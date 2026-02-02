package com.ppublica.stargazer.spotservice.api.controller;

import com.ppublica.stargazer.spotservice.api.dto.Coordinates;
import com.ppublica.stargazer.spotservice.api.dto.CreateSpotRequest;
import com.ppublica.stargazer.spotservice.api.dto.SpotDto;
import com.ppublica.stargazer.spotservice.spot.application.usecase.createspot.CreateSpotCommand;
import com.ppublica.stargazer.spotservice.spot.application.usecase.createspot.CreateSpotUseCase;
import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spot")
public class SpotController {

    private final CreateSpotUseCase createSpotUseCase;

    public SpotController(CreateSpotUseCase createSpotUseCase) {
        this.createSpotUseCase = createSpotUseCase;
    }

    @PostMapping()
    private SpotDto createSpot(@RequestBody CreateSpotRequest request) {
        CreateSpotCommand createSpotCommand =
                new CreateSpotCommand(
                        Location.create(request.coordinates().latitude(), request.coordinates().longitude()));

        Spot newSpot = createSpotUseCase.handle(createSpotCommand);

        return toSpotDto(newSpot);

    }


    SpotDto toSpotDto(Spot spot) {
        return new SpotDto(
                spot.id().value(),
                new Coordinates(spot.location().latitude(), spot.location().longitude()),
                spot.elevation().meters(),
                spot.lightPollutionRating().bortleClass().name()
                );
    }


}
