package com.ppublica.stargazer.userservice.api.dto;

public record RegisterUserRequest(String homeAddress, String displayName, String avatarUrl, String timezone) {}