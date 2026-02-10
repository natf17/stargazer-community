package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;

public interface InitializeSpotMetadataUseCase {
    SpotMetadataView handle(InitializeSpotMetadataCommand command);
}
