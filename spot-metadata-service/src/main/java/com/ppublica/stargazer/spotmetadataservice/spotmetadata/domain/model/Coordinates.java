package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model;

public class Coordinates {
    private final double latitude;
    private final double longitude;

    private Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double latitude() {
        return this.latitude;
    }

    public double longitude() {
        return this.longitude;
    }

    public static Coordinates create(double latitude, double longitude) {
        return new Coordinates(latitude, longitude);
    }

}
