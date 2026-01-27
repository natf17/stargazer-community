package com.ppublica.stargazer.userservice.api.controller;

import com.ppublica.stargazer.userservice.api.dto.HomeLocationDTO;
import com.ppublica.stargazer.userservice.api.dto.RegisterUserRequest;
import com.ppublica.stargazer.userservice.api.dto.UserDto;
import com.ppublica.stargazer.userservice.application.usecase.deregister.DeregisterUserCommand;
import com.ppublica.stargazer.userservice.application.usecase.deregister.DeregisterUserUseCase;
import com.ppublica.stargazer.userservice.application.usecase.find.FindUserQuery;
import com.ppublica.stargazer.userservice.application.usecase.find.FindUserUseCase;
import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserCommand;
import com.ppublica.stargazer.userservice.application.usecase.register.RegisterUserUseCase;
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

    public UserController(RegisterUserUseCase registerUserUseCase, FindUserUseCase findUserUseCase, DeregisterUserUseCase deregisterUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.deregisterUserUseCase = deregisterUserUseCase;
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
