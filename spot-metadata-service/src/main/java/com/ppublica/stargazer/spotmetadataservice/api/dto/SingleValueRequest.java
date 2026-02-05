package com.ppublica.stargazer.spotmetadataservice.api.dto;

import com.fasterxml.jackson.databind.JsonNode;

public record SingleValueRequest(JsonNode value) { }
