package com.ppublica.stargazer.spotservice.api.controller;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotservice.api.dto.GetSpotsByIdsRequest;
import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;
import com.ppublica.stargazer.spotservice.spot.application.mapper.SpotMapper;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin.BrowseAllSpotsAdminQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin.BrowseAllSpotsAdminUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots.BrowsePublicSpotsQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots.BrowsePublicSpotsUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids.GetSpotsByIdsQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids.GetSpotsByIdsUseCase;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/spots")
public class SpotsController {

    private final BrowseAllSpotsAdminUseCase browseAllSpotsAdminUseCase;
    private final BrowsePublicSpotsUseCase browsePublicSpotsUseCase;
    private final GetSpotsByIdsUseCase getSpotsByIdsUseCase;
    private final SpotMapper spotMapper = new SpotMapper();

    public SpotsController(BrowseAllSpotsAdminUseCase browseAllSpotsAdminUseCase,
                           BrowsePublicSpotsUseCase browsePublicSpotsUseCase,
                           GetSpotsByIdsUseCase getSpotsByIdsUseCase) {

        this.browseAllSpotsAdminUseCase = browseAllSpotsAdminUseCase;
        this.browsePublicSpotsUseCase = browsePublicSpotsUseCase;
        this.getSpotsByIdsUseCase = getSpotsByIdsUseCase;
    }

    @RequestMapping("/all")
    public List<SpotDto> browseAllAdmin() {
        List<Spot> spots = browseAllSpotsAdminUseCase.handle(new BrowseAllSpotsAdminQuery());

        return spots.stream()
                .map(spotMapper::toSpotDto)
                .collect(Collectors.toList());

    }

    @RequestMapping("/public")
    public List<SpotDto> browseAllPublic() {
        List<Spot> spots = browsePublicSpotsUseCase.handle(new BrowsePublicSpotsQuery());

        return spots.stream()
                .map(spotMapper::toSpotDto)
                .collect(Collectors.toList());

    }

    @PostMapping("/by-ids")
    public List<SpotDto> getSpotsByIds(@RequestBody GetSpotsByIdsRequest request) {

        List<Spot> spots = getSpotsByIdsUseCase.handle(new GetSpotsByIdsQuery(request.ids()));

        return spots.stream()
                .map(spotMapper::toSpotDto)
                .collect(Collectors.toList());

    }

}
