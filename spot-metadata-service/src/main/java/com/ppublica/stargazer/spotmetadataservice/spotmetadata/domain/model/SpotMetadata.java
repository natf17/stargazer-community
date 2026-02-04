package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model;

import com.ppublica.stargazer.sharedkernelspot.SpotId;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SpotMetadata {
    private final SpotMetadataId id;
    private Set<AccessPolicy> accessPolicies;
    private Set<Accessibility> accessibilities;
    private Set<Amenity> amenities;
    private Optional<TerrainInclination> terrainInclination;
    private Optional<GroundSurfaceType> groundSurfaceType;
    private Optional<SkyVisibilityBucket> skyVisibilityBucket;
    private Optional<VisibilityCeiling> visibilityCeiling;
    private Optional<GlobalHorizonVisibility> globalHorizonVisibility;
    private Optional<BestHorizonDirection> bestHorizonDirection;
    private final SpotId spotId;


    private SpotMetadata(SpotMetadataId id, SpotId spotId) {
        this.id = id;
        this.spotId = spotId;
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

    public static SpotMetadata create(SpotId spotId) {
        return new SpotMetadata(SpotMetadataId.newId(), spotId);
    }

    // fromPersistence(SpotMetadataSnapshot) to be called by repository

    public SpotMetadataId id() {
        return this.id;
    }

    public SpotId spotId() {
        return this.spotId;
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

    public Optional<VisibilityCeiling> visibilityCeiling() {
        return this.visibilityCeiling;
    }

    public void visibilityCeiling(VisibilityCeiling visibilityCeiling) {
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
