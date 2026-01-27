package com.ppublica.stargazer.userservice.application.usecase.updateprofile;

public record UpdateUserProfileCommand(String id, String displayName, String avatarUrl, String timezone) {}
