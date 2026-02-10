package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;

import java.util.List;
import java.util.Optional;

public interface SpotMetadataRepository {
    Optional<SpotMetadata> findBySpotId(SpotId spotId);
    Optional<SpotMetadata> findById(SpotMetadataId id);
    SpotMetadata save(SpotMetadata spotMetadata);
    List<SpotMetadata> findBySpotIds(List<SpotId> spotIds);
}
