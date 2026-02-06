package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;

public record SpotPersonalizationId(UserId userId, SpotId id) { }
