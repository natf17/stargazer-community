package com.ppublica.stargazer.sharedkerneluser;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

public class UserId {
    private final String value;

    private UserId(String value) {
        this.value = value;
    }

    public static UserId newId() {
        Ulid ulid = UlidCreator.getUlid();
        return new UserId(ulid.toString());
    }

    public static UserId of(String value) {
        return new UserId(value);
    }

    public String value() {
        return this.value;
    }
}
