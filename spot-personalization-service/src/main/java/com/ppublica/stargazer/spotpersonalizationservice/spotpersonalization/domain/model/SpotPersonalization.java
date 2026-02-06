package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SpotPersonalization {
    private final SpotPersonalizationId id;
    private final SpotId spotId;
    private final UserId userId;
    private Optional<String> description;
    private String name;
    private Set<AccessPolicy> accessPolicies;
    private Set<Accessibility> accessibilities;
    private Set<Amenity> amenities;
    private Optional<TerrainInclination> terrainInclination;
    private Optional<GroundSurfaceType> groundSurfaceType;
    private Optional<SkyVisibilityBucket> skyVisibilityBucket;
    private Optional<Double> visibilityCeiling;
    private Optional<GlobalHorizonVisibility> globalHorizonVisibility;
    private Optional<BestHorizonDirection> bestHorizonDirection;

    private SpotPersonalization(SpotPersonalizationId id, UserId userId, SpotId spotId, String name) {
        this.id = id;
        this.userId = userId;
        this.spotId = spotId;
        this.name = name;
        this.accessPolicies = new HashSet<>();
        this.accessibilities = new HashSet<>();
        this.amenities = new HashSet<>();
        this.terrainInclination = Optional.empty();
        this.groundSurfaceType = Optional.empty();
        this.skyVisibilityBucket = Optional.empty();
        this.visibilityCeiling = Optional.empty();
        this.globalHorizonVisibility = Optional.empty();
        this.bestHorizonDirection = Optional.empty();
    }


    public static SpotPersonalization create(SpotPersonalizationId id, UserId userId, SpotId spotId, String name) {
        return new SpotPersonalization(id, userId, spotId, name);
    }

    // fromPersistence(SpotPersonalizationSnapshot) to be called by repository

    public SpotPersonalizationId id() {
        return this.id;
    }

    public UserId userId() {
        return this.userId;
    }

    public SpotId spotId() {
        return this.spotId;
    }

    public String name() {
        return this.name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public Optional<String> description() {
        return this.description;
    }

    public void description(String description) {
        this.description = Optional.of(description);
    }

    public void clearDescription() {
        this.description = Optional.empty();
    }

    public Set<AccessPolicy> accessPolicies() {
        return Collections.unmodifiableSet(this.accessPolicies);
    }

    public void addAccessPolicy(AccessPolicy accessPolicy) {
        this.accessPolicies.add(accessPolicy);
    }

    public void removeAccessPolicy(AccessPolicy accessPolicy) {
        this.accessPolicies.remove(accessPolicy);
    }

    public Set<Accessibility> accessibilities() {
        return Collections.unmodifiableSet(this.accessibilities);
    }

    public void addAccessibility(Accessibility accessibility) {
        this.accessibilities.add(accessibility);
    }

    public void removeAccessibility(Accessibility accessibility) {
        this.accessibilities.remove(accessibility);
    }

    public Set<Amenity> amenities() {
        return Collections.unmodifiableSet(this.amenities);
    }

    public void addAmenity(Amenity amenity) {
        this.amenities.add(amenity);
    }

    public void removeAmenity(Amenity amenity) {
        this.amenities.remove(amenity);
    }

    public Optional<TerrainInclination> terrainInclination() {
        return this.terrainInclination;
    }

    public void terrainInclination(TerrainInclination terrainInclination) {
        this.terrainInclination = Optional.of(terrainInclination);
    }

    public void clearTerrainInclination() {
        this.terrainInclination = Optional.empty();
    }

    public Optional<GroundSurfaceType> groundSurfaceType() {
        return this.groundSurfaceType;
    }

    public void groundSurfaceType(GroundSurfaceType groundSurfaceType) {
        this.groundSurfaceType = Optional.of(groundSurfaceType);
    }

    public void clearGroundSurfaceType() {
        this.groundSurfaceType = Optional.empty();
    }

    public Optional<SkyVisibilityBucket> skyVisibilityBucket() {
        return this.skyVisibilityBucket;
    }

    public void skyVisibilityBucket(SkyVisibilityBucket skyVisibilityBucket) {
        this.skyVisibilityBucket = Optional.of(skyVisibilityBucket);
    }

    public void clearSkyVisibilityBucket() {
        this.skyVisibilityBucket = Optional.empty();
    }

    public Optional<Double> visibilityCeiling() {
        return this.visibilityCeiling;
    }

    public void visibilityCeiling(Double visibilityCeiling) {
        this.visibilityCeiling = Optional.of(visibilityCeiling);
    }

    public void clearVisibilityCeiling() {
        this.visibilityCeiling = Optional.empty();
    }

    public Optional<GlobalHorizonVisibility> globalHorizonVisibility() {
        return this.globalHorizonVisibility;
    }

    public void globalHorizonVisibility(GlobalHorizonVisibility globalHorizonVisibility) {
        this.globalHorizonVisibility = Optional.of(globalHorizonVisibility);
    }

    public void clearGlobalHorizonVisibility() {
        this.globalHorizonVisibility = Optional.empty();
    }

    public Optional<BestHorizonDirection> bestHorizonDirection() {
        return this.bestHorizonDirection;
    }

    public void bestHorizonDirection(BestHorizonDirection bestHorizonDirection) {
        this.bestHorizonDirection = Optional.of(bestHorizonDirection);
    }

    public void clearBestHorizonDirection() {
        this.bestHorizonDirection = Optional.empty();
    }


}
