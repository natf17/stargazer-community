package com.ppublica.stargazer.spotmetadataservice.api.controller;

import com.ppublica.stargazer.spotmetadataservice.api.dto.SpotMetadataListRequest;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataListResponse;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewbyspot.GetSpotMetadataViewBySpotQuery;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewbyspot.GetSpotMetadataViewBySpotUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewsbyspotids.GetSpotMetadataViewsBySpotIdsQuery;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewsbyspotids.GetSpotMetadataViewsBySpotIdsUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spot-metadata")
public class SpotMetadataViewController {
    private final GetSpotMetadataViewBySpotUseCase getSpotMetadataViewBySpotUseCase;
    private final GetSpotMetadataViewsBySpotIdsUseCase getSpotMetadataViewsBySpotIdsUseCase;

    public SpotMetadataViewController(GetSpotMetadataViewBySpotUseCase getSpotMetadataViewBySpotUseCase,
                                      GetSpotMetadataViewsBySpotIdsUseCase getSpotMetadataViewsBySpotIdsUseCase) {
        this.getSpotMetadataViewBySpotUseCase = getSpotMetadataViewBySpotUseCase;
        this.getSpotMetadataViewsBySpotIdsUseCase = getSpotMetadataViewsBySpotIdsUseCase;
    }

    @GetMapping("/by-spot/{id}")
    public SpotMetadataView getMetadataViewBySpotId(@PathVariable String id) {
        return getSpotMetadataViewBySpotUseCase.execute(new GetSpotMetadataViewBySpotQuery(id));
    }

    @PostMapping("/by-spot")
    public SpotMetadataListResponse getMetadataViewsBySpotIds(@RequestBody SpotMetadataListRequest request) {
        return getSpotMetadataViewsBySpotIdsUseCase.execute(new GetSpotMetadataViewsBySpotIdsQuery(request.spotIds()));
    }
}
