package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccessibility.AddAccessibilityCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccessibility.AddAccessibilityUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccesspolicy.AddAccessPolicyCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addaccesspolicy.AddAccessPolicyUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addamenity.AddAmenityCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.addamenity.AddAmenityUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearbesthorizondirection.ClearBestHorizonDirectionCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearbesthorizondirection.ClearBestHorizonDirectionUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.cleardescription.ClearDescriptionCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.cleardescription.ClearDescriptionUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearglobalhorizonvisibility.ClearGlobalHorizonVisibilityCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearglobalhorizonvisibility.ClearGlobalHorizonVisibilityUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.cleargroundsurfacetype.ClearGroundSurfaceTypeCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.cleargroundsurfacetype.ClearGroundSurfaceTypeUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearskyvisibilitybucket.ClearSkyVisibilityBucketCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearskyvisibilitybucket.ClearSkyVisibilityBucketUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearterraininclination.ClearTerrainInclinationCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearterraininclination.ClearTerrainInclinationUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearvisibilityceiling.ClearVisibilityCeilingCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.clearvisibilityceiling.ClearVisibilityCeilingUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.initializespotpersonalization.InitializeSpotPersonalizationCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.initializespotpersonalization.InitializeSpotPersonalizationUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccessibility.RemoveAccessibilityCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccessibility.RemoveAccessibilityUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccesspolicy.RemoveAccessPolicyCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeaccesspolicy.RemoveAccessPolicyUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeamenity.RemoveAmenityCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.removeamenity.RemoveAmenityUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setbesthorizondirection.SetBestHorizonDirectionCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setbesthorizondirection.SetBestHorizonDirectionUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setdescription.SetDescriptionCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setdescription.SetDescriptionUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setglobalhorizonvisibility.SetGlobalHorizonVisibilityCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setglobalhorizonvisibility.SetGlobalHorizonVisibilityUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setgroundsurfacetype.SetGroundSurfaceTypeCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setgroundsurfacetype.SetGroundSurfaceTypeUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setskyvisibilitybucket.SetSkyVisibilityBucketCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setskyvisibilitybucket.SetSkyVisibilityBucketUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setterraininclination.SetTerrainInclinationCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setterraininclination.SetTerrainInclinationUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setvisibilityceiling.SetVisibilityCeilingCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.setvisibilityceiling.SetVisibilityCeilingUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.updatename.UpdateNameCommand;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.updatename.UpdateNameUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotPersonalizationView;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import org.springframework.stereotype.Service;

@Service
public class SpotPersonalizationApplicationService {
    private final AddAccessibilityUseCase addAccessibilityUseCase;
    private final AddAccessPolicyUseCase addAccessPolicyUseCase;
    private final AddAmenityUseCase addAmenityUseCase;
    private final ClearBestHorizonDirectionUseCase clearBestHorizonDirectionUseCase;
    private final ClearDescriptionUseCase clearDescriptionUseCase;
    private final ClearGlobalHorizonVisibilityUseCase clearGlobalHorizonVisibilityUseCase;
    private final ClearGroundSurfaceTypeUseCase clearGroundSurfaceTypeUseCase;
    private final ClearSkyVisibilityBucketUseCase clearSkyVisibilityBucketUseCase;
    private final ClearTerrainInclinationUseCase clearTerrainInclinationUseCase;
    private final ClearVisibilityCeilingUseCase clearVisibilityCeilingUseCase;
    private final InitializeSpotPersonalizationUseCase initializeSpotPersonalizationUseCase;
    private final RemoveAccessibilityUseCase removeAccessibilityUseCase;
    private final RemoveAccessPolicyUseCase removeAccessPolicyUseCase;
    private final RemoveAmenityUseCase removeAmenityUseCase;
    private final SetBestHorizonDirectionUseCase setBestHorizonDirectionUseCase;
    private final SetDescriptionUseCase setDescriptionUseCase;
    private final SetGlobalHorizonVisibilityUseCase setGlobalHorizonVisibilityUseCase;
    private final SetGroundSurfaceTypeUseCase setGroundSurfaceTypeUseCase;
    private final SetSkyVisibilityBucketUseCase setSkyVisibilityBucketUseCase;
    private final SetTerrainInclinationUseCase setTerrainInclinationUseCase;
    private final SetVisibilityCeilingUseCase setVisibilityCeilingUseCase;
    private final UpdateNameUseCase updateNameUseCase;

    public SpotPersonalizationApplicationService(
            AddAccessibilityUseCase addAccessibilityUseCase,
            AddAccessPolicyUseCase addAccessPolicyUseCase,
            AddAmenityUseCase addAmenityUseCase,
            ClearBestHorizonDirectionUseCase clearBestHorizonDirectionUseCase,
            ClearDescriptionUseCase clearDescriptionUseCase,
            ClearGlobalHorizonVisibilityUseCase clearGlobalHorizonVisibilityUseCase,
            ClearGroundSurfaceTypeUseCase clearGroundSurfaceTypeUseCase,
            ClearSkyVisibilityBucketUseCase clearSkyVisibilityBucketUseCase,
            ClearTerrainInclinationUseCase clearTerrainInclinationUseCase,
            ClearVisibilityCeilingUseCase clearVisibilityCeilingUseCase,
            InitializeSpotPersonalizationUseCase initializeSpotPersonalizationUseCase,
            RemoveAccessibilityUseCase removeAccessibilityUseCase,
            RemoveAccessPolicyUseCase removeAccessPolicyUseCase,
            RemoveAmenityUseCase removeAmenityUseCase,
            SetBestHorizonDirectionUseCase setBestHorizonDirectionUseCase,
            SetDescriptionUseCase setDescriptionUseCase,
            SetGlobalHorizonVisibilityUseCase setGlobalHorizonVisibilityUseCase,
            SetGroundSurfaceTypeUseCase setGroundSurfaceTypeUseCase,
            SetSkyVisibilityBucketUseCase setSkyVisibilityBucketUseCase,
            SetTerrainInclinationUseCase setTerrainInclinationUseCase,
            SetVisibilityCeilingUseCase setVisibilityCeilingUseCase,
            UpdateNameUseCase updateNameUseCase

    ) {
        this.addAccessibilityUseCase = addAccessibilityUseCase;
        this.addAccessPolicyUseCase = addAccessPolicyUseCase;
        this.addAmenityUseCase = addAmenityUseCase;
        this.clearBestHorizonDirectionUseCase = clearBestHorizonDirectionUseCase;
        this.clearDescriptionUseCase = clearDescriptionUseCase;
        this.clearGlobalHorizonVisibilityUseCase = clearGlobalHorizonVisibilityUseCase;
        this.clearGroundSurfaceTypeUseCase = clearGroundSurfaceTypeUseCase;
        this.clearSkyVisibilityBucketUseCase = clearSkyVisibilityBucketUseCase;
        this.clearTerrainInclinationUseCase = clearTerrainInclinationUseCase;
        this.clearVisibilityCeilingUseCase = clearVisibilityCeilingUseCase;
        this.initializeSpotPersonalizationUseCase = initializeSpotPersonalizationUseCase;
        this.removeAccessibilityUseCase = removeAccessibilityUseCase;
        this.removeAccessPolicyUseCase = removeAccessPolicyUseCase;
        this.removeAmenityUseCase = removeAmenityUseCase;
        this.setBestHorizonDirectionUseCase = setBestHorizonDirectionUseCase;
        this.setDescriptionUseCase = setDescriptionUseCase;
        this.setGlobalHorizonVisibilityUseCase = setGlobalHorizonVisibilityUseCase;
        this.setGroundSurfaceTypeUseCase = setGroundSurfaceTypeUseCase;
        this.setSkyVisibilityBucketUseCase = setSkyVisibilityBucketUseCase;
        this.setTerrainInclinationUseCase = setTerrainInclinationUseCase;
        this.setVisibilityCeilingUseCase = setVisibilityCeilingUseCase;
        this.updateNameUseCase = updateNameUseCase;

    }

    public SpotPersonalizationView initializeSpotPersonalization(String spotId, String userId, String name) {
        return this.initializeSpotPersonalizationUseCase.handle(
                new InitializeSpotPersonalizationCommand(
                        SpotId.of(spotId), UserId.of(userId), name));
    }

    public void addAccessibility(String spotId, String userId, String accessibility) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.addAccessibilityUseCase.handle(
                new AddAccessibilityCommand(spotPersonalizationId, accessibility)
        );
    }

    public void removeAccessibility(String spotId, String userId, String accessibility) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.removeAccessibilityUseCase.handle(
                new RemoveAccessibilityCommand(spotPersonalizationId, accessibility));
    }

    public void addAccessPolicy(String spotId, String userId, String accessPolicy) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.addAccessPolicyUseCase.handle(
                new AddAccessPolicyCommand(spotPersonalizationId, accessPolicy));
    }

    public void removeAccessPolicy(String spotId, String userId, String accessPolicy) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.removeAccessPolicyUseCase.handle(
                new RemoveAccessPolicyCommand(spotPersonalizationId, accessPolicy));
    }

    public void addAmenity(String spotId, String userId, String amenity) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.addAmenityUseCase.handle(
                new AddAmenityCommand(spotPersonalizationId, amenity));
    }

    public void removeAmenity(String spotId, String userId, String amenity) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.removeAmenityUseCase.handle(
                new RemoveAmenityCommand(spotPersonalizationId, amenity));
    }

    public void setBestHorizonDirection(String spotId, String userId, String bestHorizonDirection) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setBestHorizonDirectionUseCase.handle(
                new SetBestHorizonDirectionCommand(spotPersonalizationId, bestHorizonDirection));
    }

    public void clearBestHorizonDirection(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearBestHorizonDirectionUseCase.handle(
                new ClearBestHorizonDirectionCommand(spotPersonalizationId));
    }

    public void setDescription(String spotId, String userId, String description) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setDescriptionUseCase.handle(
                new SetDescriptionCommand(spotPersonalizationId, description));
    }

    public void clearDescription(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearDescriptionUseCase.handle(
                new ClearDescriptionCommand(spotPersonalizationId));
    }

    public void setGlobalHorizonVisibility(String spotId, String userId, String globalHorizonVisibility) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setGlobalHorizonVisibilityUseCase.handle(
                new SetGlobalHorizonVisibilityCommand(spotPersonalizationId, globalHorizonVisibility));
    }

    public void clearGlobalHorizonVisibility(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearGlobalHorizonVisibilityUseCase.handle(
                new ClearGlobalHorizonVisibilityCommand(spotPersonalizationId));
    }

    public void setGroundSurfaceType(String spotId, String userId, String groundSurfaceType) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setGroundSurfaceTypeUseCase.handle(
                new SetGroundSurfaceTypeCommand(spotPersonalizationId, groundSurfaceType));
    }

    public void clearGroundSurfaceType(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearGroundSurfaceTypeUseCase.handle(
                new ClearGroundSurfaceTypeCommand(spotPersonalizationId));
    }

    public void setSkyVisibilityBucket(String spotId, String userId, String skyVisibilityBucket) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setSkyVisibilityBucketUseCase.handle(
                new SetSkyVisibilityBucketCommand(spotPersonalizationId, skyVisibilityBucket));
    }

    public void clearSkyVisibilityBucket(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearSkyVisibilityBucketUseCase.handle(
                new ClearSkyVisibilityBucketCommand(spotPersonalizationId));
    }

    public void setTerrainInclination(String spotId, String userId, String terrainInclination) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setTerrainInclinationUseCase.handle(
                new SetTerrainInclinationCommand(spotPersonalizationId, terrainInclination));
    }

    public void clearTerrainInclination(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearTerrainInclinationUseCase.handle(
                new ClearTerrainInclinationCommand(spotPersonalizationId));
    }

    public void setVisibilityCeiling(String spotId, String userId, double visibilityCeiling) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.setVisibilityCeilingUseCase.handle(
                new SetVisibilityCeilingCommand(spotPersonalizationId, visibilityCeiling));
    }

    public void clearVisibilityCeiling(String spotId, String userId) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.clearVisibilityCeilingUseCase.handle(
                new ClearVisibilityCeilingCommand(spotPersonalizationId));
    }

    public void updateName(String spotId, String userId, String name) {
        SpotPersonalizationId spotPersonalizationId = buildSpotPersonalizationId(spotId, userId);
        this.updateNameUseCase.handle(
                new UpdateNameCommand(spotPersonalizationId, name));
    }

    private SpotPersonalizationId buildSpotPersonalizationId(String spotId, String userId) {
        return new SpotPersonalizationId(UserId.of(userId), SpotId.of(spotId));
    }


}
