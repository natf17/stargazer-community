package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model;

public class CanonicalName {
    private final String value;

    private CanonicalName(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static CanonicalName create(String value) {
        return new CanonicalName(value);
    }

    public static CanonicalName createFallback(Coordinates coordinates) {
        return new CanonicalName(
                Double.toString(coordinates.latitude()) + "," +
                Double.toString(coordinates.longitude()));
    }
}
