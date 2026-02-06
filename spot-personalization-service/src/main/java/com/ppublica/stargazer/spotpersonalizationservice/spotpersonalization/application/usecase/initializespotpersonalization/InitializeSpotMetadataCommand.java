package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.initializespotpersonalization;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;

public record InitializeSpotMetadataCommand(SpotId spotId, UserId userId, String name) { }
