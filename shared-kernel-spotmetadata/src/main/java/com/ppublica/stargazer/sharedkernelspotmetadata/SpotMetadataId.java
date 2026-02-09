package com.ppublica.stargazer.sharedkernelspotmetadata;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

public class SpotMetadataId {
    private final String value;

    private SpotMetadataId(String id) {
        this.value = id;
    }

    public static SpotMetadataId newId() {
        Ulid ulid = UlidCreator.getUlid();
        return new SpotMetadataId(ulid.toString());
    }

    public String value() {
        return this.value;
    }

    public static SpotMetadataId of(String value) {
        return new SpotMetadataId(value);
    }
}
