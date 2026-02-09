package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spotmetadata;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.List;

public interface SpotMetadataLookupPort {
    List<SpotMetadataPortDto> loadSpotMetadata(List<SpotId> spotIds);
}
