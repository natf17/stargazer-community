package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

public interface SpotLookupPort {
    boolean spotExists(SpotId spotId);
}
