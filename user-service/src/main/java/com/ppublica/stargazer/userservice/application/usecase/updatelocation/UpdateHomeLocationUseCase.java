package com.ppublica.stargazer.userservice.application.usecase.updatelocation;

import com.ppublica.stargazer.userservice.application.usecase.updateprofile.UpdateUserProfileCommand;
import com.ppublica.stargazer.userservice.domain.model.User;

public interface UpdateHomeLocationUseCase {
    User handle(UpdateHomeLocationCommand updatedHomeLocation);
}
