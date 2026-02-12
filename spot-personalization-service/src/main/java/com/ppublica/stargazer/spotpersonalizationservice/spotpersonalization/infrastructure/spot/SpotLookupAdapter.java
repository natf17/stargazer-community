package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.infrastructure.spot;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.Coordinates;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotPortDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Optional;

@Component
public class SpotLookupAdapter implements SpotLookupPort {
    private final WebClient webClient;

    public SpotLookupAdapter(WebClient.Builder builder,
                              @Value("${spot-service.base-url}") String baseUrl) {
        this.webClient = builder
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public boolean doesSpotExist(SpotId spotId) {

        try {
            SpotResponse spot = webClient.get()
                .uri("/spot/{id}", spotId.value())
                .retrieve()
                .bodyToMono(SpotResponse.class)
                .block();

            return true;
        } catch (WebClientResponseException.NotFound ex) {
            return false;
        }
    }

    @Override
    public List<SpotPortDto> loadSpots(List<SpotId> spotIds) {
        List<String> spotIdStrings = spotIds.stream()
                .map(SpotId::value)
                .toList();

        return webClient.post()
                .uri("/spots/by-ids")
                .bodyValue(new GetSpotsByIdsRequest(spotIdStrings))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<SpotResponse>>(){})
                .map(list -> list.stream()
                        .map(this::toSpotPortDto)
                        .toList())
                .block();
    }

    @Override
    public Optional<SpotPortDto> loadSpot(SpotId spotId) {
        try {
            return webClient.get()
                    .uri("/spot/{id}", spotId.value())
                    .retrieve()
                    .bodyToMono(SpotResponse.class)
                    .map(this::toSpotPortDto)
                    .blockOptional();

        } catch (WebClientResponseException.NotFound ex) {
            return Optional.empty();
        }

    }

    @Override
    public List<SpotPortDto> getAllPublicSpots() {

        return webClient.post()
                .uri("/spots/public")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<SpotResponse>>(){})
                .map(list -> list.stream()
                        .map(this::toSpotPortDto)
                        .toList())
                .block();
    }

    SpotPortDto toSpotPortDto(SpotResponse spotResponse) {
        return new SpotPortDto(
                spotResponse.id(),
                new Coordinates(spotResponse.coordinates().latitude(), spotResponse.coordinates().longitude()),
                spotResponse.elevationMeters(),
                spotResponse.bortleClass()
            );
    }
}
