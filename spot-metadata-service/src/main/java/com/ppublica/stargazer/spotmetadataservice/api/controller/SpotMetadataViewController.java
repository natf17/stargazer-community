package com.ppublica.stargazer.spotmetadataservice.api.controller;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataListResponse;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewbyspot.GetSpotMetadataViewBySpotQuery;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewbyspot.GetSpotMetadataViewBySpotUseCase;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/by-spot")
    public SpotMetadataListResponse getMetadataViewsBySpotIds(@RequestBody SpotMetadataListResponse ids) {
        return ;
    }
}
