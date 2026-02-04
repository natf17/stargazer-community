package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setbesthorizondirection;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.BestHorizonDirection;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetBestHorizonDirectionHandler implements SetBestHorizonDirectionUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public SetBestHorizonDirectionHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetBestHorizonDirectionCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        BestHorizonDirection bestHorizonDirection = BestHorizonDirection.valueOf(command.bestHorizonDirection());

        spotMetadata.bestHorizonDirection(bestHorizonDirection);

        spotMetadataRepository.save(spotMetadata);

    }
}
