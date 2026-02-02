package com.ppublica.stargazer.spotservice.spot.domain.model;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

public class Spot {
    private final SpotId spotId;
    private final Location location;
    private Elevation elevation;
    private Visibility visibility;
    private LightPollutionRating lightPollutionRating;

    private Spot(SpotId spotId, Location location, Visibility visibility) {
        this.spotId = spotId;
        this.location = location;
        this.visibility = visibility;
    }

    public static Spot create(Location location) {
        return new Spot(SpotId.newId(), location, Visibility.PRIVATE);
    }

    public Location location() {
        return this.location;
    }

    public Elevation elevation() {
        return this.elevation;
    }

    public Visibility visibility() {
        return this.visibility;
    }

    public LightPollutionRating lightPollutionRating() {
        return this.lightPollutionRating;
    }

    public void updateElevation(ElevationUpdate elevationUpdate) {
        this.elevation = Elevation.create(elevationUpdate.meters(), elevationUpdate.src());
    }

    public void updateLightPollutionRating(LightPollutionRatingUpdate lightPollutionRatingUpdate) {
        this.lightPollutionRating = LightPollutionRating.create(lightPollutionRatingUpdate.bortleClass(), lightPollutionRatingUpdate.src());
    }

    public SpotId id() {
        return spotId;
    }

    public void makePublic() {
        this.visibility = Visibility.PUBLIC;
    }

    public void makePrivate() {
        this.visibility = Visibility.PRIVATE;
    }


}
