package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;

public interface InitializeSpotMetadataUseCase {
    SpotMetadata handle(InitializeSpotMetadataCommand command);
}
