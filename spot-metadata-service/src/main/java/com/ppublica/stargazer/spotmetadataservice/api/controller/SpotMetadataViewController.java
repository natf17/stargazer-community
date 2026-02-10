package com.ppublica.stargazer.spotmetadataservice.api.controller;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewybyspot.GetSpotMetadataViewBySpotQuery;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewybyspot.GetSpotMetadataViewBySpotUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spot-metadata")
public class SpotMetadataViewController {
    private final GetSpotMetadataViewBySpotUseCase getSpotMetadataViewBySpotUseCase;

    public SpotMetadataViewController(GetSpotMetadataViewBySpotUseCase getSpotMetadataViewBySpotUseCase) {
        this.getSpotMetadataViewBySpotUseCase = getSpotMetadataViewBySpotUseCase;
    }

    @GetMapping("/by-spot/{id}")
    public SpotMetadataView getMetadataViewBySpotId(@PathVariable String id) {
        return getSpotMetadataViewBySpotUseCase.execute(new GetSpotMetadataViewBySpotQuery(id));
    }
}
