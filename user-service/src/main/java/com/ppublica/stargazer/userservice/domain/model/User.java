package com.ppublica.stargazer.userservice.domain.model;

import java.time.Instant;

public class User {
    private final String id;
    private UserStatus status;
    private UserProfile profile;
    private UserHomeLocation homeLocation;

    private User(String id, UserStatus status, UserProfile profile, UserHomeLocation homeLocation) {
        this.id = id;
        this.status = status;
        this.profile = profile;
        this.homeLocation = homeLocation;
    }

    public static User create(String id, UserProfile profile, UserHomeLocation homeLocation, UserStatus status) {

        return new User(id, status, profile, homeLocation);
    }

    public UserProfile profile() {
        return this.profile;
    }

    public UserHomeLocation homeLocation() {
        return this.homeLocation;
    }

    public UserStatus status() {
        return this.status;
    }

    public void deregister() {
        this.status = UserStatus.DEREGISTERED;
    }

}
