package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.getspotmetadataviewsbyspotids;

import java.util.List;

public record GetSpotMetadataViewsBySpotIdsQuery(List<String> spotIds) { }
