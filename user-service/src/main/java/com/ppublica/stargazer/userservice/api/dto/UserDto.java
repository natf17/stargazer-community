package com.ppublica.stargazer.userservice.api.dto;

public record UserDto(HomeLocationDTO homeLocation, String displayName, String avatarUrl, String timezone) {
}
