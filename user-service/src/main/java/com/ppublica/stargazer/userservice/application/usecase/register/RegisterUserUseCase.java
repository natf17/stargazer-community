package com.ppublica.stargazer.userservice.application.usecase.register;

import com.ppublica.stargazer.userservice.domain.model.User;

public interface RegisterUserUseCase {
    User handle(RegisterUserCommand registerUser);
}
