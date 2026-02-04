package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.Optional;

public interface SpotLookupPort {
    Optional<SpotLocationDto> fetchLocation(SpotId spotId);
}
