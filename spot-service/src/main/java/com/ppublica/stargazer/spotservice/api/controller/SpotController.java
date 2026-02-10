package com.ppublica.stargazer.spotservice.api.controller;

import com.ppublica.stargazer.spotservice.api.dto.CreateSpotRequest;
import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;
import com.ppublica.stargazer.spotservice.spot.application.mapper.SpotMapper;
import com.ppublica.stargazer.spotservice.spot.application.usecase.createspot.CreateSpotCommand;
import com.ppublica.stargazer.spotservice.spot.application.usecase.createspot.CreateSpotUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.getspotbyid.GetSpotByIdQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.getspotbyid.GetSpotByIdUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.publishspot.PublishSpotCommand;
import com.ppublica.stargazer.spotservice.spot.application.usecase.publishspot.PublishSpotUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spot")
public class SpotController {

    private final CreateSpotUseCase createSpotUseCase;
    private final PublishSpotUseCase publishSpotUseCase;
    private final GetSpotByIdUseCase getSpotByIdUseCase;
    private final SpotMapper spotMapper = new SpotMapper();

    public SpotController(CreateSpotUseCase createSpotUseCase,
                          PublishSpotUseCase publishSpotUseCase,
                          GetSpotByIdUseCase getSpotByIdUseCase) {
        this.createSpotUseCase = createSpotUseCase;
        this.publishSpotUseCase = publishSpotUseCase;
        this.getSpotByIdUseCase = getSpotByIdUseCase;
    }

    @PostMapping()
    public SpotDto createSpot(@RequestBody CreateSpotRequest request) {
        CreateSpotCommand createSpotCommand =
                new CreateSpotCommand(
                        request.coordinates().latitude(), request.coordinates().longitude());

        return createSpotUseCase.handle(createSpotCommand);

    }

    @PostMapping("/publish/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publishSpot(@PathVariable("id") String id) {

        publishSpotUseCase.handle(new PublishSpotCommand(id));

    }

    @GetMapping("/{id}")
    public SpotDto getSpot(@PathVariable String id) {
        return spotMapper.toSpotDto(getSpotByIdUseCase.execute(new GetSpotByIdQuery(id)));
    }


}
