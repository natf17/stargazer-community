package com.ppublica.stargazer.spotmetadataservice.spotmetadata.infrastructure.spot;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.CoordinatesDto;
import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.port.spot.SpotLocationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@WireMockTest(httpPort=0)
public class SpotLookupAdapterTest {

    SpotLookupAdapter adapter;

    @BeforeEach
    void setup(WireMockRuntimeInfo info) {
        WebClient client = WebClient.builder().baseUrl(info.getHttpBaseUrl()).build();
        this.adapter = new SpotLookupAdapter(WebClient.builder(), info.getHttpBaseUrl());
    }

    @Test
    void returnsSpot() {
        stubFor(get("/spot/123")
                .willReturn(okJson("""
                        {
                            "id": "123",
                            "coordinates": {
                                "latitude": 40.7334168,
                                "longitude": -73.8966543
                            },
                            "elevationMeters": 12344,
                            "bortleClass": "ONE"
                        }
                        """)));

        Optional<SpotLocationDto> spotOpt = adapter.fetchLocation(SpotId.of("123"));

        assertThat(spotOpt)
                .isPresent()
                .contains(new SpotLocationDto(
                        new CoordinatesDto(40.7334168, -73.8966543)
                ));

    }




}
