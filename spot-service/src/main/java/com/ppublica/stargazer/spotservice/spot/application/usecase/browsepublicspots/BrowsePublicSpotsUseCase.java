package com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots;

import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

import java.util.List;

public interface BrowsePublicSpotsUseCase {
    List<Spot> handle(BrowsePublicSpotsQuery query);
}
