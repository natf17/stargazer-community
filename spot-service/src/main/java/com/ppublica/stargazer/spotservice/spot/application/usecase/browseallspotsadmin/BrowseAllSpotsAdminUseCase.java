package com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin;

import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;

import java.util.List;

public interface BrowseAllSpotsAdminUseCase {
    List<SpotDto> handle(BrowseAllSpotsAdminQuery query);
}
