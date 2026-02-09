package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.domain.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

public record Spot(
        SpotId spotId,
        Coordinates coordinates,
        Elevation elevation,
        LightPollutionRating lightPollutionRating){}
