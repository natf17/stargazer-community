package com.ppublica.stargazer.spotmetadataservice.spotmetadata.domain.model;

public enum BestHorizonDirection {
    // facing N: if 45deg slice of azimuths in this direction has < 10deg obstruction
    NONE, N, NE, E, SE, S, SW, W, NW
}
