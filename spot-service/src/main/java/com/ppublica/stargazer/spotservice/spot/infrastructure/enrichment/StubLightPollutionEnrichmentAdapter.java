package com.ppublica.stargazer.spotservice.spot.infrastructure.enrichment;

import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.LightPollutionRatingData;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.LightPollutionRatingEnrichmentPort;
import com.ppublica.stargazer.spotservice.spot.domain.model.BortleClass;
import com.ppublica.stargazer.spotservice.spot.domain.model.LightPollutionSrc;
import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import org.springframework.stereotype.Component;

/*
 * As of February 2026, no official, stable, reliable API exists for sky brightness. Will look for a solution
 * in the near future.
 * Maybe look into: https://github.com/Starrierskies/SQM-repository-repository
 */
@Component
public class StubLightPollutionEnrichmentAdapter implements LightPollutionRatingEnrichmentPort {
    @Override
    public LightPollutionRatingData fetchLightPollutionRating(Location location) {
        return new LightPollutionRatingData(BortleClass.UNKNOWN, LightPollutionSrc.UNKNOWN);
    }
}
