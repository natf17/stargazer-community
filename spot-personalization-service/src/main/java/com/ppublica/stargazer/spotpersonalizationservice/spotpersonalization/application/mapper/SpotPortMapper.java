package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Coordinates;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Elevation;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.LightPollutionRating;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot.Spot;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotPortDto;

public class SpotPortMapper {
    public Spot toSpot(SpotPortDto spotPortDto) {
        return new Spot(
                SpotId.of(spotPortDto.id()),
                new Coordinates(spotPortDto.coordinates().latitude(), spotPortDto.coordinates().longitude()),
                new Elevation(spotPortDto.elevationMeters(), null),
                new LightPollutionRating(Double.parseDouble(spotPortDto.bortleClass()), null)
        );
    }
}
