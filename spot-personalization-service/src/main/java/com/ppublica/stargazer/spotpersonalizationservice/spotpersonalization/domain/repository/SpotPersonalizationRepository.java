package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository;

import com.ppublica.stargazer.sharedkerneluser.UserId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;

import java.util.List;
import java.util.Optional;

public interface SpotPersonalizationRepository {
    Optional<SpotPersonalization> findById(SpotPersonalizationId id);
    List<SpotPersonalization> findByUserId(UserId userId);
    SpotPersonalization save(SpotPersonalization spotPersonalization);
}
