package com.ppublica.stargazer.userservice.api.controller;

import com.ppublica.stargazer.userservice.api.dto.*;
import com.ppublica.stargazer.userservice.application.usecase.deregister.DeregisterUserCommand;
import com.ppublica.stargazer.userservice.application.usecase.deregister.DeregisterUserUseCase;
import com.ppublica.stargazer.userservice.application.usecase.find.FindUserQuery;
import com.ppublica.stargazer.userservice.application.usecase.find.FindUserUseCase;
import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserCommand;
import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserUseCase;
import com.ppublica.stargazer.userservice.application.usecase.updatelocation.UpdateHomeLocationCommand;
import com.ppublica.stargazer.userservice.application.usecase.updatelocation.UpdateHomeLocationUseCase;
import com.ppublica.stargazer.userservice.application.usecase.updateprofile.UpdateUserProfileCommand;
import com.ppublica.stargazer.userservice.application.usecase.updateprofile.UpdateUserProfileUseCase;
import com.ppublica.stargazer.userservice.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

/*
 * User-facing API
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final DeregisterUserUseCase deregisterUserUseCase;
    private final UpdateHomeLocationUseCase updateHomeLocationUseCase;
    private final UpdateUserProfileUseCase updateUserProfileUseCase;

    public UserController(RegisterUserUseCase registerUserUseCase,
                          FindUserUseCase findUserUseCase,
                          DeregisterUserUseCase deregisterUserUseCase,
                          UpdateHomeLocationUseCase updateHomeLocationUseCase,
                          UpdateUserProfileUseCase updateUserProfileUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.deregisterUserUseCase = deregisterUserUseCase;
        this.updateHomeLocationUseCase = updateHomeLocationUseCase;
        this.updateUserProfileUseCase = updateUserProfileUseCase;

    }


    @GetMapping
    public UserDto user(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();

        User user = findUserUseCase.handle(new FindUserQuery(userId));

        return toUserDto(user);

    }

    @PostMapping("/register")
    public UserDto register(@AuthenticationPrincipal Jwt jwt, @RequestBody RegisterUserRequest registerUserRequest) {
        String userId = jwt.getSubject();

        RegisterUserCommand command = new RegisterUserCommand(
                userId,
                registerUserRequest.homeAddress(),
                registerUserRequest.displayName(),
                registerUserRequest.avatarUrl(),
                registerUserRequest.timezone()
                );

        User registeredUser = registerUserUseCase.handle(command);

        return toUserDto(registeredUser);
    }

    @PostMapping("/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivate(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();

        deregisterUserUseCase.handle(new DeregisterUserCommand(userId));


    }

    @PatchMapping("/profile")
    public UserDto updateProfile(@AuthenticationPrincipal Jwt jwt, @RequestBody UserProfileUpdateRequest updateRequest ) {
        String userId = jwt.getSubject();

        User user = updateUserProfileUseCase.handle(
                new UpdateUserProfileCommand(
                        userId,
                        updateRequest.displayName(),
                        updateRequest.avatarUrl(),
                        updateRequest.timezone()));



        return toUserDto(user);
    }

    @PatchMapping("/home-location")
    public UserDto updateHomeLocation(@AuthenticationPrincipal Jwt jwt, @RequestBody UserHomeLocationUpdateRequest updateRequest ) {
        String userId = jwt.getSubject();

        User user = updateHomeLocationUseCase.handle(
                new UpdateHomeLocationCommand(
                        userId,
                        updateRequest.address()));


        return toUserDto(user);
    }

    UserDto toUserDto(User user) {
        return new UserDto(
                new HomeLocationDTO(
                        user.homeLocation().latitude(),
                        user.homeLocation().longitude(),
                        user.homeLocation().canonicalAddress()),
                user.profile().displayName(),
                user.profile().avatarUrl(),
                user.profile().timezone()
        );
    }



}
