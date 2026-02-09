package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.List;

public interface SpotLookupPort {
    boolean doesSpotExist(SpotId spotId);
    List<SpotPortDto> loadSpots(List<SpotId> spotIds);
}
