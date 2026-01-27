package com.ppublica.stargazer.userservice.application.port.geocoding;

public interface GeocodingService {
    GeocodedAddress geocode(String address);
}
