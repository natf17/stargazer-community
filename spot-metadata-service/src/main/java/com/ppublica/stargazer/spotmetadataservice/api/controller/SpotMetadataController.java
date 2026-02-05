package com.ppublica.stargazer.spotmetadataservice.api.controller;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.api.dto.InitializeSpotMetadataRequest;
import com.ppublica.stargazer.spotmetadataservice.api.dto.SpotMetadataDto;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.SpotMetadataApplicationService;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata.InitializeSpotMetadataCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spot-metadata")
public class SpotMetadataController {
    private final SpotMetadataApplicationService service;

    public SpotMetadataController(SpotMetadataApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpotMetadataDto initializeSpotMetadata(@RequestBody InitializeSpotMetadataRequest request) {
        SpotId spotId = SpotId.of(request.spotId());

        InitializeSpotMetadataCommand command = new InitializeSpotMetadataCommand(spotId, request.name());

        SpotMetadata spotMetadata = service.initializeSpotMetadata(command);

        return toSpotMetadataDto(spotMetadata);

    }

    SpotMetadataDto toSpotMetadataDto(SpotMetadata spotMetadata) {
        return new SpotMetadataDto(spotMetadata.id().value());
    }

}
