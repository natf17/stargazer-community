package com.ppublica.stargazer.spotservice.api.controller;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotservice.api.dto.Coordinates;
import com.ppublica.stargazer.spotservice.api.dto.CreateSpotRequest;
import com.ppublica.stargazer.spotservice.api.dto.SpotDto;
import com.ppublica.stargazer.spotservice.api.mapper.SpotMapper;
import com.ppublica.stargazer.spotservice.spot.application.usecase.createspot.CreateSpotCommand;
import com.ppublica.stargazer.spotservice.spot.application.usecase.createspot.CreateSpotUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.publishspot.PublishSpotCommand;
import com.ppublica.stargazer.spotservice.spot.application.usecase.publishspot.PublishSpotUseCase;
import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spot")
public class SpotController {

    private final CreateSpotUseCase createSpotUseCase;
    private final PublishSpotUseCase publishSpotUseCase;
    private final SpotMapper spotMapper = new SpotMapper();

    public SpotController(CreateSpotUseCase createSpotUseCase, PublishSpotUseCase publishSpotUseCase) {
        this.createSpotUseCase = createSpotUseCase;
        this.publishSpotUseCase = publishSpotUseCase;
    }

    @PostMapping()
    public SpotDto createSpot(@RequestBody CreateSpotRequest request) {
        CreateSpotCommand createSpotCommand =
                new CreateSpotCommand(
                        Location.create(request.coordinates().latitude(), request.coordinates().longitude()));

        Spot newSpot = createSpotUseCase.handle(createSpotCommand);

        return spotMapper.toSpotDto(newSpot);

    }

    @PostMapping("/publish/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publishSpot(@PathVariable("id") String id) {
        SpotId spotId = SpotId.of(id);

        publishSpotUseCase.handle(new PublishSpotCommand(spotId));

    }


}
