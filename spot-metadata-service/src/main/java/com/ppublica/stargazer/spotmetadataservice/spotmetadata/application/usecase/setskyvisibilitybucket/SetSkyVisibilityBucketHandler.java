package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setskyvisibilitybucket;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SkyVisibilityBucket;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetSkyVisibilityBucketHandler implements SetSkyVisibilityBucketUseCase{
    private final SpotMetadataRepository spotMetadataRepository;

    public SetSkyVisibilityBucketHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetSkyVisibilityBucketCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        SkyVisibilityBucket skyVisibilityBucket = SkyVisibilityBucket.valueOf(command.skyVisibilityBucket());

        spotMetadata.skyVisibilityBucket(skyVisibilityBucket);

        spotMetadataRepository.save(spotMetadata);
    }
}
