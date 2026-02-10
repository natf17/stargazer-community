package com.ppublica.stargazer.spotmetadataservice.api.dto;

import java.util.List;

public record GetSpotMetadataBySpotIdsRequest(List<String> ids) { }
