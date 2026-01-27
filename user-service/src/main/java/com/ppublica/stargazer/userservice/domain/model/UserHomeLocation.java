package com.ppublica.stargazer.userservice.domain.model;

/*
 * Immutable user home location entity.
 */
public class UserHomeLocation {
    private double latitude;
    private double longitude;
    private String canonicalAddress;

    private UserHomeLocation(double latitude, double longitude, String canonicalAddress) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.canonicalAddress = canonicalAddress;
    }

    public static UserHomeLocation create(double latitude, double longitude, String canonicalAddress) {
        return new UserHomeLocation(latitude, longitude, canonicalAddress);
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public String canonicalAddress() {
        return this.canonicalAddress;
    }

    void latitude(double latitude) {
        this.latitude = latitude;
    }

    void longitude(double longitude) {
        this.longitude = latitude;
    }

    void address(String canonicalAddress) {
        this.canonicalAddress = canonicalAddress;
    }


}

