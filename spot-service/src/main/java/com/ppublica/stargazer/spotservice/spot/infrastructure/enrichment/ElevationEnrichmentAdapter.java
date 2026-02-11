package com.ppublica.stargazer.spotservice.spot.infrastructure.enrichment;

import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.ElevationData;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.ElevationEnrichmentPort;
import com.ppublica.stargazer.spotservice.spot.domain.model.ElevationSrc;
import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ElevationEnrichmentAdapter implements ElevationEnrichmentPort {
    private final WebClient webClient;

    public ElevationEnrichmentAdapter(WebClient.Builder builder,
                                      @Value("spot-service.enrichment.elevation.api.base-url")String baseUrl) {
        this.webClient = builder
                .baseUrl(baseUrl)
                .build();

    }

    @Override
    public ElevationData fetchElevation(Location location) {
        ElevationResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .queryParam("latitude", location.latitude())
                    .queryParam("longitude", location.longitude())
                    .build())
                .retrieve()
                .bodyToMono(ElevationResponse.class)
                .block();


        return new ElevationData(response.elevation().getFirst(), ElevationSrc.PROVIDED);
    }

}
