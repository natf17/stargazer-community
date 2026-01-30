package com.ppublica.stargazer.spotservice.spot.application.port.enrichment;

import com.ppublica.stargazer.spotservice.spot.domain.model.Location;

public interface LightPollutionRatingEnrichmentPort {
    LightPollutionRatingData fetchLightPollutionRating (Location location);
}
