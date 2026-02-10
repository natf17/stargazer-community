package com.ppublica.stargazer.spotmetadataservice.api.controller;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkernelspotmetadata.SpotMetadataId;
import com.ppublica.stargazer.spotmetadataservice.api.dto.InitializeSpotMetadataRequest;
import com.ppublica.stargazer.spotmetadataservice.api.dto.SingleValueRequest;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.SpotMetadataApplicationService;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.dto.SpotMetadataView;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccessibility.AddAccessibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccesspolicy.AddAccessPolicyCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addamenity.AddAmenityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearbesthorizondirection.ClearBestHorizonDirectionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleardescription.ClearDescriptionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearglobalhorizonvisibility.ClearGlobalHorizonVisibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleargroundsurfacetype.ClearGroundSurfaceTypeCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearskyvisibilitybucket.ClearSkyVisibilityBucketCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearterraininclination.ClearTerrainInclinationCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearvisibilityceiling.ClearVisibilityCeilingCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata.InitializeSpotMetadataCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccessibility.RemoveAccessibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccesspolicy.RemoveAccessPolicyCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity.RemoveAmenityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setbesthorizondirection.SetBestHorizonDirectionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setdescription.SetDescriptionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setglobalhorizonvisibility.SetGlobalHorizonVisibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setgroundsurfacetype.SetGroundSurfaceTypeCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setskyvisibilitybucket.SetSkyVisibilityBucketCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setterraininclination.SetTerrainInclinationCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setvisibilityceiling.SetVisibilityCeilingCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.updatename.UpdateNameCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spot-metadata")
public class SpotMetadataController {
    private final SpotMetadataApplicationService service;

    public SpotMetadataController(SpotMetadataApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SpotMetadataView initializeSpotMetadata(@RequestBody InitializeSpotMetadataRequest request) {
        SpotId spotId = SpotId.of(request.spotId());

        InitializeSpotMetadataCommand command = new InitializeSpotMetadataCommand(spotId, request.name());

        return service.initializeSpotMetadata(command);

    }

    @PostMapping("/{id}/add-accessibility")
    public void addAccesibility(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.addAccessibility(
                new AddAccessibilityCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/remove-accessibility")
    public void removeAccessibility(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.removeAccessibility(
                new RemoveAccessibilityCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/add-access-policy")
    public void addAccessPolicy(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.addAccessPolicy(
                new AddAccessPolicyCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/remove-access-policy")
    public void removeAccessPolicy(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.removeAccessPolicy(
                new RemoveAccessPolicyCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/add-amenity")
    public void addAmenity(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.addAmenity(
                new AddAmenityCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/remove-amenity")
    public void removeAmenity(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.removeAmenity(
                new RemoveAmenityCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/set-best-horizon-direction")
    public void setBestHorizonDirection(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setBestHorizonDirection(
                new SetBestHorizonDirectionCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/clear-best-horizon-direction")
    public void clearBestHorizonDirection(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearBestHorizonDirection(
                new ClearBestHorizonDirectionCommand(spotMetadataId));
    }

    @PostMapping("/{id}/set-description")
    public void setDescription(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setDescription(
                new SetDescriptionCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/clear-description")
    public void clearDescription(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearDescription(
                new ClearDescriptionCommand(spotMetadataId));
    }

    @PostMapping("/{id}/set-global-horizon-visibility")
    public void setGlobalHorizonVisibility(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setGlobalHorizonVisibility(
                new SetGlobalHorizonVisibilityCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/clear-global-horizon-visibility")
    public void clearGlobalHorizonVisibility(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearGlobalHorizonVisibility(
                new ClearGlobalHorizonVisibilityCommand(spotMetadataId));
    }

    @PostMapping("/{id}/set-ground-surface-type")
    public void setGroundSurfaceType(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setGroundSurfaceType(
                new SetGroundSurfaceTypeCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/clear-ground-surface-type")
    public void clearGroundSurfaceType(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearGroundSurfaceType(
                new ClearGroundSurfaceTypeCommand(spotMetadataId));
    }

    @PostMapping("/{id}/set-sky-visibility-bucket")
    public void setSkyVisibilityBucket(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setSkyVisibilityBucket(
                new SetSkyVisibilityBucketCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/clear-sky-visibility-bucket")
    public void clearSkyVisibilityBucket(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearSkyVisibilityBucket(
                new ClearSkyVisibilityBucketCommand(spotMetadataId));
    }

    @PostMapping("/{id}/set-terrain-inclination")
    public void setTerrainInclination(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setTerrainInclination(
                new SetTerrainInclinationCommand(spotMetadataId, request.value().asText()));
    }

    @PostMapping("/{id}/clear-terrain-inclination")
    public void clearTerrainInclination(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearTerrainInclination(
                new ClearTerrainInclinationCommand(spotMetadataId));
    }

    @PostMapping("/{id}/set-visibility-ceiling")
    public void setVisibilityCeiling(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.setVisibilityCeiling(
                new SetVisibilityCeilingCommand(spotMetadataId, request.value().asDouble()));
    }

    @PostMapping("/{id}/clear-visibility-ceiling")
    public void clearVisibilityCeiling(@PathVariable String id) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.clearVisibilityCeiling(
                new ClearVisibilityCeilingCommand(spotMetadataId));
    }

    @PostMapping("/{id}/update-name")
    public void clearVisibilityCeiling(@PathVariable String id, @RequestBody SingleValueRequest request) {
        SpotMetadataId spotMetadataId = SpotMetadataId.of(id);

        service.updateName(
                new UpdateNameCommand(spotMetadataId, request.value().asText()));
    }


}
