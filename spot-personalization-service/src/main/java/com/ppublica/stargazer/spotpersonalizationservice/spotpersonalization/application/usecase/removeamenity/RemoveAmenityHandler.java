package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeamenity;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.Amenity;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;

public class RemoveAmenityHandler implements RemoveAmenityUseCase {
    private final SpotPersonalizationRepository repository;

    public RemoveAmenityHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(RemoveAmenityCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        Amenity amenity = Amenity.valueOf(command.amenity());

        spotPersonalization.removeAmenity(amenity);

        repository.save(spotPersonalization);
    }

}
