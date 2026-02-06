package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.initializespotpersonalization;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;

public interface InitializeSpotPersonalizationUseCase {
    SpotPersonalization handle(InitializeSpotPersonalizationCommand command);
}
