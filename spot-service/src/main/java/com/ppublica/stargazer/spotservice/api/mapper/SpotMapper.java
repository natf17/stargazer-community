package com.ppublica.stargazer.spotservice.api.mapper;

import com.ppublica.stargazer.spotservice.api.dto.Coordinates;
import com.ppublica.stargazer.spotservice.api.dto.SpotDto;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

public class SpotMapper {

    public SpotDto toSpotDto(Spot spot) {
        return new SpotDto(
                spot.id().value(),
                new Coordinates(spot.location().latitude(), spot.location().longitude()),
                spot.elevation().meters(),
                spot.lightPollutionRating().bortleClass().name()
        );
    }
}
