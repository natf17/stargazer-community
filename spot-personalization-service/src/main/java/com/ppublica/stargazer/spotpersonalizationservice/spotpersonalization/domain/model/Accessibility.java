package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model;

public enum Accessibility {
    VEHICLE_ACCESSIBLE, // You can drive directly to the spot
    HIKE_IN, // Must walk/hike to reach it
    WHEELCHAIR_ACCESSIBLE, // Fully accessible, ADA-friendly
    PAVED_PATH, // Smooth, paved walking path
    GRAVEL_PATH, // Gravel walking path
    DIRT_TRAIL, // Natural dirt trail
    STAIRS_REQUIRED, // Must climb stairs
    STEEP_TRAIL // Trail with significant incline
}
