package com.ppublica.stargazer.userservice.application.usecase.find;

import com.ppublica.stargazer.userservice.application.exception.UserAlreadyExistsException;
import com.ppublica.stargazer.userservice.application.exception.UserNotFoundException;
import com.ppublica.stargazer.userservice.domain.model.User;
import com.ppublica.stargazer.userservice.domain.model.UserStatus;
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

        User user = userRepository.findById(command.userId())
                .orElseThrow(UserNotFoundException::new);

        if(user.status() == UserStatus.DEREGISTERED) {
           throw new UserNotFoundException();
        }

        return user;
    }
}
