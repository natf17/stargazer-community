package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

public interface SpotLookupPort {
    boolean doesSpotExist(SpotId spotId);
}
