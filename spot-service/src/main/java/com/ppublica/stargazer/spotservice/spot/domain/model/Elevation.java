package com.ppublica.stargazer.spotservice.spot.domain.model;

public class Elevation {
    private final double meters;
    private final ElevationSrc elevationSrc;

    Elevation(double meters, ElevationSrc elevationSrc) {
        this.meters = meters;
        this.elevationSrc = elevationSrc;
    }

    public static Elevation create(double meters, ElevationSrc elevationSrc) {
        return new Elevation(meters, elevationSrc);
    }

    public double meters() {
        return this.meters;
    }

    public ElevationSrc elevationSrc() {
        return this.elevationSrc;
    }
}
