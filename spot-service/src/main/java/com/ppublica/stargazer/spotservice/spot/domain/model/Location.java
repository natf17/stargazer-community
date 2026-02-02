package com.ppublica.stargazer.spotservice.spot.domain.model;

public class Location {
    private final double latitude;
    private final double longitude;

    Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public static Location create(double latitude, double longitude) {
        return new Location(latitude, longitude);
    }

}
