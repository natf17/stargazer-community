package com.ppublica.stargazer.userservice.api.controller;

import com.ppublica.stargazer.userservice.api.dto.HomeLocationDTO;
import com.ppublica.stargazer.userservice.api.dto.RegisterUserRequest;
import com.ppublica.stargazer.userservice.api.dto.UserDto;
import com.ppublica.stargazer.userservice.application.usecase.find.FindUserCommand;
import com.ppublica.stargazer.userservice.application.usecase.find.FindUserUseCase;
import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserCommand;
import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserUseCase;
import com.ppublica.stargazer.userservice.domain.model.User;
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

    public UserController(RegisterUserUseCase registerUserUseCase, FindUserUseCase findUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.findUserUseCase = findUserUseCase;
    }


    @GetMapping
    public UserDto user(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getSubject();

        User user = findUserUseCase.handle(new FindUserCommand(userId));

        return toUserDto(user);

    }

    @PostMapping
    @RequestMapping("/register")
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

    @PostMapping
    @RequestMapping("/deactivate")
    public void deactivate(@AuthenticationPrincipal Jwt jwt) {
        // user soft-deletes himself
        throw new UnsupportedOperationException();
    }

    @PatchMapping
    public UserDto update(@AuthenticationPrincipal Jwt jwt/*, @RequestBody UserProfileUpdateRequest updateRequest*/) {

        throw new UnsupportedOperationException();
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
