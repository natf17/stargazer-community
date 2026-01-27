package com.ppublica.stargazer.userservice.application.usecase.register;

public record RegisterUserCommand(
        String id,
        String canonicalAddress,
        String displayName,
        String avatarUrl,
        String timezone
        ) {
}
