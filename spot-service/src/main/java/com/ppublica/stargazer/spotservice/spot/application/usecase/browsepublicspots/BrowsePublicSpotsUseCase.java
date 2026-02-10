package com.ppublica.stargazer.spotservice.spot.application.usecase.browsepublicspots;

import com.ppublica.stargazer.spotservice.spot.application.view.SpotDto;

import java.util.List;

public interface BrowsePublicSpotsUseCase {
    List<SpotDto> handle(BrowsePublicSpotsQuery query);
}
