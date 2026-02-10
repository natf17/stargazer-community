package com.ppublica.stargazer.spotservice.api.controller;

import com.ppublica.stargazer.spotservice.api.dto.GetSpotsByIdsRequest;
import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin.BrowseAllSpotsAdminQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin.BrowseAllSpotsAdminUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots.BrowsePublicSpotsQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots.BrowsePublicSpotsUseCase;
import com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids.GetSpotsByIdsQuery;
import com.ppublica.stargazer.spotservice.spot.application.usecase.getspotsbyids.GetSpotsByIdsUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spots")
public class SpotsController {

    private final BrowseAllSpotsAdminUseCase browseAllSpotsAdminUseCase;
    private final BrowsePublicSpotsUseCase browsePublicSpotsUseCase;
    private final GetSpotsByIdsUseCase getSpotsByIdsUseCase;

    public SpotsController(BrowseAllSpotsAdminUseCase browseAllSpotsAdminUseCase,
                           BrowsePublicSpotsUseCase browsePublicSpotsUseCase,
                           GetSpotsByIdsUseCase getSpotsByIdsUseCase) {

        this.browseAllSpotsAdminUseCase = browseAllSpotsAdminUseCase;
        this.browsePublicSpotsUseCase = browsePublicSpotsUseCase;
        this.getSpotsByIdsUseCase = getSpotsByIdsUseCase;
    }

    @RequestMapping("/all")
    public List<SpotDto> browseAllAdmin() {

        return browseAllSpotsAdminUseCase.handle(new BrowseAllSpotsAdminQuery());

    }

    @RequestMapping("/public")
    public List<SpotDto> browseAllPublic() {

       return browsePublicSpotsUseCase.handle(new BrowsePublicSpotsQuery());

    }

    @PostMapping("/by-ids")
    public List<SpotDto> getSpotsByIds(@RequestBody GetSpotsByIdsRequest request) {

        return getSpotsByIdsUseCase.handle(new GetSpotsByIdsQuery(request.ids()));

    }

}
