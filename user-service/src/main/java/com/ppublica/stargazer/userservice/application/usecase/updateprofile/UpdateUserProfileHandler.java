package com.ppublica.stargazer.userservice.application.usecase.updateprofile;

import com.ppublica.stargazer.userservice.application.exception.UserNotFoundException;
import com.ppublica.stargazer.userservice.domain.model.User;
import com.ppublica.stargazer.userservice.domain.model.UserProfileUpdate;
import com.ppublica.stargazer.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UpdateUserProfileHandler implements UpdateUserProfileUseCase {

    private final UserRepository userRepository;

    public UpdateUserProfileHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(UpdateUserProfileCommand updatedUserProfile) {
        User user = userRepository.findById(updatedUserProfile.id())
                .orElseThrow(UserNotFoundException::new);

        user.update(new UserProfileUpdate(
                updatedUserProfile.displayName(),
                updatedUserProfile.avatarUrl(),
                updatedUserProfile.timezone(),
                Instant.now()
        ));

        userRepository.save(user);

        return user;
    }
}
