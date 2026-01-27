package com.ppublica.stargazer.userservice.domain.model;

import java.time.Instant;

public class User {
    private final String id;
    private final UserProfile profile;
    private final UserHomeLocation homeLocation;

    private User(String id, UserProfile profile, UserHomeLocation homeLocation) {
        this.id = id;
        this.profile = profile;
        this.homeLocation = homeLocation;
    }

    public static User create(String id, UserProfile profile, UserHomeLocation homeLocation) {

        return new User(id, profile, homeLocation);
    }

    public UserProfile profile() {
        return this.profile;
    }

    public UserHomeLocation homeLocation() {
        return this.homeLocation;
    }


}
