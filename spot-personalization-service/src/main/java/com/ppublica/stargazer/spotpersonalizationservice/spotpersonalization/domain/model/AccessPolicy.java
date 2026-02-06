package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model;

public enum AccessPolicy {
    PUBLIC, // Open to anyone
    PUBLIC_DAYTIME_ONLY, // Open to all, but closed at night
    NIGHT_ACCESS_ALLOWED, // Explicitly allowed at night
    PERMIT_REQUIRED, // Requires a permit (day or night)
    CAMPERS_ONLY, // Only accessible to registered campers
    MEMBERS_ONLY, // Astronomy clubs, private preserves
    PRIVATE, // Private property, no general access
    PRIVATE_WITH_PERMISSION, // Private but owner may grant access
    FEE_REQUIRED // Entry or parking fee
}
