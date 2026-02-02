package com.ppublica.stargazer.spotservice.spot.application.usecase.browseallspotsadmin;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

import java.util.List;

public interface BrowseAllSpotsAdminUseCase {
    List<Spot> handle(BrowseAllSpotsAdminQuery query);
}
