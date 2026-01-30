package com.ppublica.stargazer.spotservice.spot.domain.repository;

import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

import java.util.Optional;

public interface SpotRepository {
    Optional<Spot> findByLocation(Location location);
    Optional<Spot> findById();
    Spot save(Spot newSpot);
}
