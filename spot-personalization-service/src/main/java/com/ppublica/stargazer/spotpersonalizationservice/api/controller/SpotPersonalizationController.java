package com.ppublica.stargazer.spotpersonalizationservice.api.controller;

import com.ppublica.stargazer.spotpersonalizationservice.api.dto.InitializeSpotPersonalizationRequest;
import com.ppublica.stargazer.spotpersonalizationservice.api.dto.SingleValueRequest;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.SpotPersonalizationApplicationService;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotPersonalizationView;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spot/{spotId}/personalization")
public class SpotPersonalizationController {
    private final SpotPersonalizationApplicationService service;

    public SpotPersonalizationController(SpotPersonalizationApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpotPersonalizationView initializeSpotPersonalization(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody InitializeSpotPersonalizationRequest request) {

        return service.initializeSpotPersonalization(spotId, jwt.getSubject(), request.name());

    }

    @PostMapping("add-accessibility")
    public void addAccesibility(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.addAccessibility(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/remove-accessibility")
    public void removeAccessibility(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.removeAccessibility(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/add-access-policy")
    public void addAccessPolicy(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.addAccessPolicy(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/remove-access-policy")
    public void removeAccessPolicy(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.removeAccessPolicy(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/add-amenity")
    public void addAmenity(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.addAmenity(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/remove-amenity")
    public void removeAmenity(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.removeAmenity(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/set-best-horizon-direction")
    public void setBestHorizonDirection(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setBestHorizonDirection(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/clear-best-horizon-direction")
    public void clearBestHorizonDirection(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearBestHorizonDirection(spotId, jwt.getSubject());
    }

    @PostMapping("/set-description")
    public void setDescription(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setDescription(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/clear-description")
    public void clearDescription(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearDescription(spotId, jwt.getSubject());
    }

    @PostMapping("/set-global-horizon-visibility")
    public void setGlobalHorizonVisibility(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setGlobalHorizonVisibility(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/clear-global-horizon-visibility")
    public void clearGlobalHorizonVisibility(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearGlobalHorizonVisibility(spotId, jwt.getSubject());
    }

    @PostMapping("/set-ground-surface-type")
    public void setGroundSurfaceType(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setGroundSurfaceType(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/clear-ground-surface-type")
    public void clearGroundSurfaceType(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearGroundSurfaceType(spotId, jwt.getSubject());
    }

    @PostMapping("/set-sky-visibility-bucket")
    public void setSkyVisibilityBucket(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setSkyVisibilityBucket(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/clear-sky-visibility-bucket")
    public void clearSkyVisibilityBucket(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearSkyVisibilityBucket(spotId, jwt.getSubject());
    }

    @PostMapping("/set-terrain-inclination")
    public void setTerrainInclination(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setTerrainInclination(spotId, jwt.getSubject(), request.value().asText());
    }

    @PostMapping("/clear-terrain-inclination")
    public void clearTerrainInclination(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearTerrainInclination(spotId, jwt.getSubject());
    }

    @PostMapping("/set-visibility-ceiling")
    public void setVisibilityCeiling(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.setVisibilityCeiling(spotId, jwt.getSubject(), request.value().asDouble());
    }

    @PostMapping("/clear-visibility-ceiling")
    public void clearVisibilityCeiling(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId) {

        service.clearVisibilityCeiling(spotId, jwt.getSubject());
    }

    @PostMapping("/update-name")
    public void clearVisibilityCeiling(@AuthenticationPrincipal Jwt jwt, @PathVariable String spotId, @RequestBody SingleValueRequest request) {

        service.updateName(spotId, jwt.getSubject(), request.value().asText());
    }




}
