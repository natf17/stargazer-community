package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;

import java.util.Optional;

public interface SpotMetadataRepository {
    Optional<SpotMetadata> findBySpotId(SpotId spotId);
    SpotMetadata save(SpotMetadata spotMetadata);
}
