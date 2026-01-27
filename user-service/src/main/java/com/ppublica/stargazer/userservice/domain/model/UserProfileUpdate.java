package com.ppublica.stargazer.userservice.domain.model;

import java.time.Instant;

public record UserProfileUpdate(String displayName, String avatarUrl, String timezone, Instant updatedAt) {}
