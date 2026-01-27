package com.ppublica.stargazer.userservice.application.usecase.find;

import com.ppublica.stargazer.userservice.domain.model.User;

public interface FindUserUseCase {
    User handle(FindUserCommand command);
}
