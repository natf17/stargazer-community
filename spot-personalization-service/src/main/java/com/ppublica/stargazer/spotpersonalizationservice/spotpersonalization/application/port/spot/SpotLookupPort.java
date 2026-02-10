package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.List;
import java.util.Optional;

public interface SpotLookupPort {
    boolean doesSpotExist(SpotId spotId);
    List<SpotPortDto> loadSpots(List<SpotId> spotIds);
    Optional<SpotPortDto> loadSpot(SpotId spotId);
    List<SpotPortDto> getAllPublicSpots();
}
