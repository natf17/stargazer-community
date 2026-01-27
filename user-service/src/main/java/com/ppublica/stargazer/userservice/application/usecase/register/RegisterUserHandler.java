package com.ppublica.stargazer.userservice.application.usecase.register;

import com.ppublica.stargazer.userservice.application.exception.UserAlreadyExistsException;
import com.ppublica.stargazer.userservice.application.port.geocoding.GeocodedAddress;
import com.ppublica.stargazer.userservice.application.port.geocoding.GeocodingService;
import com.ppublica.stargazer.userservice.domain.model.User;
import com.ppublica.stargazer.userservice.domain.model.UserHomeLocation;
import com.ppublica.stargazer.userservice.domain.model.UserProfile;
import com.ppublica.stargazer.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class RegisterUserHandler implements RegisterUserUseCase {

    private final GeocodingService geocodingService;
    private final UserRepository userRepository;

    public RegisterUserHandler(GeocodingService geocodingService, UserRepository userRepository) {
        this.geocodingService = geocodingService;
        this.userRepository = userRepository;
    }

    @Override
    public User handle(RegisterUserCommand registerUser) {

        boolean userExists = userRepository.doesUserExistBySubject(registerUser.id());

        if(userExists) {
            throw new UserAlreadyExistsException();
        }

        GeocodedAddress address = geocodingService.geocode(registerUser.canonicalAddress());

        User newUser = User.create(
                registerUser.id(),
                UserProfile.create(
                        registerUser.displayName(),
                        registerUser.avatarUrl(),
                        registerUser.timezone(),
                        Instant.now(),
                        Instant.now()),
                UserHomeLocation.create(
                        address.latitude(),
                        address.longitude(),
                        address.address())

                );

        userRepository.save(newUser);

        return newUser;
    }
}
