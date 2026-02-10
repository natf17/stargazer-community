package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.List;
import java.util.Optional;

public interface SpotMetadataLookupPort {
    List<SpotMetadataPortDto> loadSpotMetadata(List<SpotId> spotIds);
    Optional<SpotMetadataPortDto> loadSpotMetadata(SpotId spotId);
}
