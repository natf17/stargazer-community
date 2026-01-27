package com.ppublica.stargazer.userservice.application.usecase.find;

import com.ppublica.stargazer.userservice.application.exception.UserAlreadyExistsException;
import com.ppublica.stargazer.userservice.domain.model.User;
import com.ppublica.stargazer.userservice.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class FindUserHandler implements FindUserUseCase {

    private final UserRepository userRepository;

    public FindUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(FindUserCommand command) {

        return userRepository.findById(command.userId())
                .orElseThrow(UserAlreadyExistsException::new);
    }
}
