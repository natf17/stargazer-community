package com.ppublica.stargazer.spotservice.spot.infrastructure.enrichment;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.ppublica.stargazer.spotservice.spot.application.port.enrichment.ElevationData;
import com.ppublica.stargazer.spotservice.spot.domain.model.ElevationSrc;
import com.ppublica.stargazer.spotservice.spot.domain.model.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@WireMockTest(httpPort=0)
public class ElevationEnrichmentAdapterTest {

    ElevationEnrichmentAdapter adapter;

    @BeforeEach
    void setup(WireMockRuntimeInfo info) {
        WebClient client = WebClient.builder().baseUrl(info.getHttpBaseUrl()).build();
        this.adapter = new ElevationEnrichmentAdapter(WebClient.builder(), info.getHttpBaseUrl());
    }

    @Test
    void returnsElevationData() {
        stubFor(get(urlPathEqualTo("/")).withQueryParam("latitude", equalTo("40.7334168"))
                .withQueryParam("longitude", equalTo("-73.8966543"))
                .willReturn(okJson("""
                        {
                            "elevation": [38.0]
                        }
                        """)));

        ElevationData elevationData = adapter.fetchElevation(
                Location.create(40.7334168, -73.8966543));

        assertEquals(new ElevationData(38.0, ElevationSrc.PROVIDED), elevationData);

    }
    
}
