package com.ppublica.stargazer.spotmetadataservice.spotmetadata.infrastructure.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLocationDto;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLookupPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Optional;

@Component
public class SpotLookupAdapter implements SpotLookupPort {

    private final WebClient webClient;

    public SpotLookupAdapter(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://spot-service")
                .build();
    }
    @Override
    public Optional<SpotLocationDto> fetchLocation(SpotId spotId) {
        try {
            return webClient.get()
                    .uri("/spot/{id}", spotId.value())
                    .retrieve()
                    .bodyToMono(SpotLocationDto.class)
                    .blockOptional();
        } catch (WebClientResponseException.NotFound ex) {
            return Optional.empty();
        }
    }
}
