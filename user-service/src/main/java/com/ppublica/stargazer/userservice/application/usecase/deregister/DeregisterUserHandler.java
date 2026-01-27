package com.ppublica.stargazer.userservice.application.usecase.deregister;

import com.ppublica.stargazer.userservice.application.exception.UserNotFoundException;
import com.ppublica.stargazer.userservice.domain.model.User;
import com.ppublica.stargazer.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DeregisterUserHandler implements DeregisterUserUseCase {

    private final UserRepository userRepository;

    public DeregisterUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void handle(DeregisterUserCommand deregisterUser) {
        User user = userRepository.findById(deregisterUser.id())
                .orElseThrow(UserNotFoundException::new);

        user.deregister(Instant.now());

        userRepository.save(user);

    }
}
