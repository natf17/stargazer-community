package com.ppublica.stargazer.sharedkernelspot;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

public class SpotId {
    private final String value;

    private SpotId(String value) {
        this.value = value;
    }

    public static SpotId newId() {
        Ulid ulid = UlidCreator.getUlid();
        return new SpotId(ulid.toString());
    }

    public static SpotId of(String value) {
        return new SpotId(value);
    }

    public String value() {
        return this.value;
    }
}
