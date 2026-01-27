package com.ppublica.stargazer.userservice.application.usecase.updateprofile;

import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserCommand;
import com.ppublica.stargazer.userservice.domain.model.User;

public interface UpdateUserProfileUseCase {
    User handle(UpdateUserProfileCommand updatedUserProfile);
}
