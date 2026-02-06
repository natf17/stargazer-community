package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addamenity;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.Amenity;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;
import org.springframework.stereotype.Component;

@Component
public class AddAmenityHandler implements AddAmenityUseCase {

    private final SpotPersonalizationRepository repository;

    public AddAmenityHandler(SpotPersonalizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(AddAmenityCommand command) {
        SpotPersonalizationId id = command.id();

        SpotPersonalization spotPersonalization = repository.findById(id)
                .orElseThrow(SpotPersonalizationNotFoundException::new);

        Amenity amenity = Amenity.valueOf(command.amenity());

        spotPersonalization.addAmenity(amenity);

        repository.save(spotPersonalization);

    }

}
