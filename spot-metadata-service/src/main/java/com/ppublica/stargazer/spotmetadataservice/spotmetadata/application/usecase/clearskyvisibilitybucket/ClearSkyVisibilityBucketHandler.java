package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearskyvisibilitybucket;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class ClearSkyVisibilityBucketHandler implements ClearSkyVisibilityBucketUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public ClearSkyVisibilityBucketHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(ClearSkyVisibilityBucketCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        spotMetadata.clearSkyVisibilityBucket();

        spotMetadataRepository.save(spotMetadata);
    }
}
