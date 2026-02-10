package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setglobalhorizonvisibility;

import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.exception.SpotMetadataNotFoundException;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.GlobalHorizonVisibility;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model.SpotMetadata;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.repository.SpotMetadataRepository;

public class SetGlobalHorizonVisibilityHandler implements SetGlobalHorizonVisibilityUseCase {
    private final SpotMetadataRepository spotMetadataRepository;

    public SetGlobalHorizonVisibilityHandler(SpotMetadataRepository spotMetadataRepository) {
        this.spotMetadataRepository = spotMetadataRepository;
    }

    @Override
    public void handle(SetGlobalHorizonVisibilityCommand command) {
        SpotMetadataId id = command.id();

        SpotMetadata spotMetadata = spotMetadataRepository.findById(id)
                .orElseThrow(SpotMetadataNotFoundException::new);

        GlobalHorizonVisibility globalHorizonVisibility = GlobalHorizonVisibility.valueOf(command.globalHorizonVisibility());

        spotMetadata.globalHorizonVisibility(globalHorizonVisibility);

        spotMetadataRepository.save(spotMetadata);

    }
}
