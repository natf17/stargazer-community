package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.infrastructure.spot;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.Coordinates;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotPortDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@WireMockTest(httpPort=0)
public class SpotLookupAdapterTest {
    SpotLookupAdapter adapter;

    @BeforeEach
    void setup(WireMockRuntimeInfo info) {
        WebClient client = WebClient.builder().baseUrl(info.getHttpBaseUrl()).build();
        this.adapter = new SpotLookupAdapter(WebClient.builder(), info.getHttpBaseUrl());
    }

    @Test
    void spotExists() {
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

        boolean doesSpotExist = adapter.doesSpotExist(SpotId.of("123"));

        assertTrue(doesSpotExist);

    }

    @Test
    void spotDoesNotExist() {
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

        boolean doesSpotExist = adapter.doesSpotExist(SpotId.of("1"));

        assertFalse(doesSpotExist);

    }

    @Test
    void loadSpots() {
        stubFor(post("/spots/by-ids")
                .withRequestBody(equalToJson("""
                        {
                            "ids": ["1", "2", "3"]
                        }
                        """))
                .willReturn(okJson("""
                        [{
                            "id": "1",
                            "coordinates": {
                                "latitude": 40.1,
                                "longitude": -73.9
                            },
                            "elevationMeters": 1,
                            "bortleClass": "ONE"
                        },
                        {
                            "id": "2",
                            "coordinates": {
                                "latitude": 40.2,
                                "longitude": -73.8
                            },
                            "elevationMeters": 2,
                            "bortleClass": "ONE"
                        },
                        {
                            "id": "3",
                            "coordinates": {
                                "latitude": 40.3,
                                "longitude": -73.7
                            },
                            "elevationMeters": 3,
                            "bortleClass": "ONE"
                        }]
                        """)));

        List<SpotPortDto> spotsReceived = adapter.loadSpots(List.of(
                SpotId.of("1"),
                SpotId.of("2"),
                SpotId.of("3")));

        assertEquals(3, spotsReceived.size());

    }

    @Test
    void loadSpotThatExists() {
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

        Optional<SpotPortDto> spotOpt = adapter.loadSpot(SpotId.of("123"));

        assertThat(spotOpt)
                .isPresent()
                .contains(new SpotPortDto(
                        "123",
                        new Coordinates(40.7334168, -73.8966543),
                        12344,
                        "ONE"
                ));

    }

    @Test
    void loadSpotThatDoesNotExist() {

        Optional<SpotPortDto> spotOpt = adapter.loadSpot(SpotId.of("123"));

        assertTrue(spotOpt.isEmpty());

    }

    @Test
    void loadPublicSpots() {
        stubFor(post("/spots/public")
                .willReturn(okJson("""
                        [{
                            "id": "1",
                            "coordinates": {
                                "latitude": 40.1,
                                "longitude": -73.9
                            },
                            "elevationMeters": 1,
                            "bortleClass": "ONE"
                        },
                        {
                            "id": "2",
                            "coordinates": {
                                "latitude": 40.2,
                                "longitude": -73.8
                            },
                            "elevationMeters": 2,
                            "bortleClass": "ONE"
                        }]
                        """)));

        List<SpotPortDto> spotsReceived = adapter.getAllPublicSpots();

        assertEquals(2, spotsReceived.size());
    }


}
