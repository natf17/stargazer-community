package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model;

public class CanonicalDescription {
    private final String value;

    private CanonicalDescription(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static CanonicalDescription create(String value) {
        return new CanonicalDescription(value);
    }
}
