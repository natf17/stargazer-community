package com.ppublica.stargazer.spotservice.spot.domain.model;

public class LightPollutionRating {
    private final BortleClass bortleClass;
    private final LightPollutionSrc src;

    private LightPollutionRating(BortleClass bortleClass, LightPollutionSrc src) {
        this.bortleClass = bortleClass;
        this.src = src;
    }

    public static LightPollutionRating create(BortleClass bortleClass, LightPollutionSrc src) {
        return new LightPollutionRating(bortleClass, src);
    }

    public BortleClass bortleClass() {
        return this.bortleClass;
    }

    public LightPollutionSrc src() {
        return this.src;
    }

}
