package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccessibility.AddAccessibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccessibility.AddAccessibilityUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccesspolicy.AddAccessPolicyCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addaccesspolicy.AddAccessPolicyUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addamenity.AddAmenityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.addamenity.AddAmenityUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearbesthorizondirection.ClearBestHorizonDirectionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearbesthorizondirection.ClearBestHorizonDirectionUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleardescription.ClearDescriptionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleardescription.ClearDescriptionUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearglobalhorizonvisibility.ClearGlobalHorizonVisibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearglobalhorizonvisibility.ClearGlobalHorizonVisibilityUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleargroundsurfacetype.ClearGroundSurfaceTypeCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.cleargroundsurfacetype.ClearGroundSurfaceTypeUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearskyvisibilitybucket.ClearSkyVisibilityBucketCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearskyvisibilitybucket.ClearSkyVisibilityBucketUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearterraininclination.ClearTerrainInclinationCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearterraininclination.ClearTerrainInclinationUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearvisibilityceiling.ClearVisibilityCeilingCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.clearvisibilityceiling.ClearVisibilityCeilingUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata.InitializeSpotMetadataCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.initializespotmetadata.InitializeSpotMetadataUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccessibility.RemoveAccessibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccessibility.RemoveAccessibilityUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccesspolicy.RemoveAccessPolicyCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccesspolicy.RemoveAccessPolicyUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity.RemoveAmenityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity.RemoveAmenityUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setbesthorizondirection.SetBestHorizonDirectionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setbesthorizondirection.SetBestHorizonDirectionUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setdescription.SetDescriptionCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setdescription.SetDescriptionUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setglobalhorizonvisibility.SetGlobalHorizonVisibilityCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setglobalhorizonvisibility.SetGlobalHorizonVisibilityUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setgroundsurfacetype.SetGroundSurfaceTypeCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setgroundsurfacetype.SetGroundSurfaceTypeUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setskyvisibilitybucket.SetSkyVisibilityBucketCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setskyvisibilitybucket.SetSkyVisibilityBucketUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setterraininclination.SetTerrainInclinationCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setterraininclination.SetTerrainInclinationUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setvisibilityceiling.SetVisibilityCeilingCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.setvisibilityceiling.SetVisibilityCeilingUseCase;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.updatename.UpdateNameCommand;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.updatename.UpdateNameUseCase;
import org.springframework.stereotype.Service;

@Service
public class SpotMetadataApplicationService {
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
    private final InitializeSpotMetadataUseCase initializeSpotMetadataUseCase;
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

    public SpotMetadataApplicationService(
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
            InitializeSpotMetadataUseCase initializeSpotMetadataUseCase,
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
        this.initializeSpotMetadataUseCase = initializeSpotMetadataUseCase;
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

    public void initializeSpotMetadata(InitializeSpotMetadataCommand command) {
        this.initializeSpotMetadataUseCase.handle(command);
    }

    public void addAccessibility(AddAccessibilityCommand command) {
        this.addAccessibilityUseCase.handle(command);
    }

    public void removeAccessibility(RemoveAccessibilityCommand command) {
        this.removeAccessibilityUseCase.handle(command);
    }

    public void addAccessPolicy(AddAccessPolicyCommand command) {
        this.addAccessPolicyUseCase.handle(command);
    }

    public void removeAccessPolicy(RemoveAccessPolicyCommand command) {
        this.removeAccessPolicyUseCase.handle(command);
    }

    public void addAmenity(AddAmenityCommand command) {
        this.addAmenityUseCase.handle(command);
    }

    public void removeAmenity(RemoveAmenityCommand command) {
        this.removeAmenityUseCase.handle(command);
    }

    public void setBestHorizonDirection(SetBestHorizonDirectionCommand command) {
        this.setBestHorizonDirectionUseCase.handle(command);
    }

    public void clearBestHorizonDirection(ClearBestHorizonDirectionCommand command) {
        this.clearBestHorizonDirectionUseCase.handle(command);
    }

    public void setDescription(SetDescriptionCommand command) {
        this.setDescriptionUseCase.handle(command);
    }

    public void clearDescription(ClearDescriptionCommand command) {
        this.clearDescriptionUseCase.handle(command);
    }

    public void setGlobalHorizonVisibility(SetGlobalHorizonVisibilityCommand command) {
        this.setGlobalHorizonVisibilityUseCase.handle(command);
    }

    public void clearGlobalHorizonVisibility(ClearGlobalHorizonVisibilityCommand command) {
        this.clearGlobalHorizonVisibilityUseCase.handle(command);
    }

    public void setGroundSurfaceType(SetGroundSurfaceTypeCommand command) {
        this.setGroundSurfaceTypeUseCase.handle(command);
    }

    public void clearGroundSurfaceType(ClearGroundSurfaceTypeCommand command) {
        this.clearGroundSurfaceTypeUseCase.handle(command);
    }

    public void setSkyVisibilityBucket(SetSkyVisibilityBucketCommand command) {
        this.setSkyVisibilityBucketUseCase.handle(command);
    }

    public void clearSkyVisibilityBucket(ClearSkyVisibilityBucketCommand command) {
        this.clearSkyVisibilityBucketUseCase.handle(command);
    }

    public void setTerrainInclination(SetTerrainInclinationCommand command) {
        this.setTerrainInclinationUseCase.handle(command);
    }

    public void clearTerrainInclination(ClearTerrainInclinationCommand command) {
        this.clearTerrainInclinationUseCase.handle(command);
    }

    public void setVisibilityCeiling(SetVisibilityCeilingCommand command) {
        this.setVisibilityCeilingUseCase.handle(command);
    }

    public void clearVisibilityCeiling(ClearVisibilityCeilingCommand command) {
        this.clearVisibilityCeilingUseCase.handle(command);
    }

    public void updateName(UpdateNameCommand command) {
        this.updateNameUseCase.handle(command);
    }



}
