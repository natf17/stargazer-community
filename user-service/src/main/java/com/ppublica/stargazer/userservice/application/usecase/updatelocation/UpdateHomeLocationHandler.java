package com.ppublica.stargazer.userservice.application.usecase.updatelocation;

import com.ppublica.stargazer.userservice.application.exception.UserNotFoundException;
import com.ppublica.stargazer.userservice.application.port.geocoding.GeocodedAddress;
import com.ppublica.stargazer.userservice.application.port.geocoding.GeocodingService;
import com.ppublica.stargazer.userservice.domain.model.User;
import com.ppublica.stargazer.userservice.domain.model.UserHomeLocationUpdate;
import com.ppublica.stargazer.userservice.domain.repository.UserRepository;

public class UpdateHomeLocationHandler implements UpdateHomeLocationUseCase {

    private final GeocodingService geocodingService;
    private final UserRepository userRepository;

    public UpdateHomeLocationHandler(GeocodingService geocodingService, UserRepository userRepository) {
        this.geocodingService = geocodingService;
        this.userRepository = userRepository;
    }

    @Override
    public User handle(UpdateHomeLocationCommand updatedHomeLocation) {
        User user = userRepository.findById(updatedHomeLocation.id())
                .orElseThrow(UserNotFoundException::new);

        GeocodedAddress address = geocodingService.geocode(updatedHomeLocation.canonicalAddress());

        user.update(new UserHomeLocationUpdate(
                address.latitude(),
                address.longitude(),
                address.address()));

        userRepository.save(user);

        return user;
    }
}
