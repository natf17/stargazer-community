package com.ppublica.stargazer.spotpersonalizationservice.api.controller;

import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallmyspotviews.GetAllMySpotViewsQuery;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallmyspotviews.GetAllMySpotViewsUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallspotviews.GetAllSpotViewsQuery;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getallspotviews.GetAllSpotViewsUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getspotviewusecase.GetSpotViewQuery;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.getspotviewusecase.GetSpotViewUseCase;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewListResponse;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotViewResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SpotViewController {
    private final GetSpotViewUseCase getSpotViewUseCase;
    private final GetAllSpotViewsUseCase getAllSpotViewsUseCase;
    private final GetAllMySpotViewsUseCase getAllMySpotViewsUseCase;

    public SpotViewController(GetSpotViewUseCase getSpotViewUseCase,
                              GetAllSpotViewsUseCase getAllSpotViewsUseCase,
                              GetAllMySpotViewsUseCase getAllMySpotViewsUseCase) {
        this.getSpotViewUseCase = getSpotViewUseCase;
        this.getAllSpotViewsUseCase = getAllSpotViewsUseCase;
        this.getAllMySpotViewsUseCase = getAllMySpotViewsUseCase;
    }

    @GetMapping("/spot-view/{id}")
    public SpotViewResponse getSpotView(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return getSpotViewUseCase.execute(new GetSpotViewQuery(id, extractUserId(jwt)));
    }

    @GetMapping("/spot-view")
    public SpotViewListResponse getAllSpotViews(@AuthenticationPrincipal Jwt jwt) {
        return getAllSpotViewsUseCase.execute(new GetAllSpotViewsQuery(extractUserId(jwt)));
    }

    @GetMapping("/my/spots")
    public SpotViewListResponse getAllMySpotViews(@AuthenticationPrincipal Jwt jwt) {
        return getAllMySpotViewsUseCase.execute(new GetAllMySpotViewsQuery(extractRequiredUserId(jwt)));
    }

    Optional<String> extractUserId(Jwt jwt) {
        return Optional.ofNullable(jwt).map(Jwt::getSubject);
    }

    String extractRequiredUserId(Jwt jwt) {
        return jwt.getSubject();
    }


}
