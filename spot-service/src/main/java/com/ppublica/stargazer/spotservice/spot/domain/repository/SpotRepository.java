package com.ppublica.stargazer.spotservice.spot.domain.repository;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import com.ppublica.stargazer.spotservice.spot.domain.model.Spot;

import java.util.List;
import java.util.Optional;

public interface SpotRepository {
    List<Spot> findAll(); // for admin-use
    List<Spot> findAllPublished();
    List<Spot> findByIds(List<SpotId> spotIds);
    Optional<Spot> findByLocation(Location location);
    Optional<Spot> findById(SpotId spotId);
    Spot save(Spot newSpot);
}
