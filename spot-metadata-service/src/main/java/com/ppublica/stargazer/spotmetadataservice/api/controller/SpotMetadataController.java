package com.ppublica.stargazer.spotmetadataservice.api.controller;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.SpotMetadataApplicationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spot-metadata")
public class SpotMetadataController {
    private final SpotMetadataApplicationService service;

    public SpotMetadataController(SpotMetadataApplicationService service) {
        this.service = service;
    }

    

}
