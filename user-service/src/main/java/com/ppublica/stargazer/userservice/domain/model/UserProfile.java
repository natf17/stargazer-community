package com.ppublica.stargazer.userservice.domain.model;

import java.time.Instant;

/*
 * Immutable user profile entity.
 */
public class UserProfile {
    private final String displayName;
    private final String avatarUrl;
    private final String timezone;
    private final Instant createdAt;
    private final Instant updatedAt;

    private UserProfile(String displayName, String avatarUrl, String timezone, Instant createdAt, Instant updatedAt) {
        this.displayName = displayName;
        this.avatarUrl = avatarUrl;
        this.timezone = timezone;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserProfile create(String displayName, String avatarUrl, String timezone, Instant createdAt, Instant updatedAt) {
        return new UserProfile(displayName, avatarUrl, timezone, createdAt, updatedAt);
    }

    public String displayName() {
        return this.displayName;
    }

    public String avatarUrl() {
        return this.avatarUrl;
    }

    public String timezone() {
        return this.timezone;
    }




}
