package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.usecase.initializespotpersonalization;

import com.ppublica.stargazer.sharedkernelspot.SpotId;
import com.ppublica.stargazer.sharedkerneluser.UserId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.SpotPersonalizationAlreadyExistsException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.exception.UserNotFoundException;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.mapper.SpotPersonalizationMapper;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.spot.SpotLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.user.UserLookupPort;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.view.SpotPersonalizationView;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalization;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.model.SpotPersonalizationId;
import com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.domain.repository.SpotPersonalizationRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializeSpotPersonalizationHandler implements InitializeSpotPersonalizationUseCase {

    private final SpotPersonalizationRepository repository;
    private final UserLookupPort userLookupPort;
    private final SpotLookupPort spotLookupPort;
    private final SpotPersonalizationMapper spotPersonalizationMapper = new SpotPersonalizationMapper();

    public InitializeSpotPersonalizationHandler(SpotPersonalizationRepository spotPersonalizationRepository,
                                                UserLookupPort userLookupPort,
                                                SpotLookupPort spotLookupPort) {
        this.repository = spotPersonalizationRepository;
        this.userLookupPort = userLookupPort;
        this.spotLookupPort = spotLookupPort;
    }

    @Override
    public SpotPersonalizationView handle(InitializeSpotPersonalizationCommand command) {
        SpotId spotId = command.spotId();
        UserId userId = command.userId();
        String name = command.name();

        boolean doesUserExist = userLookupPort.doesUserExist(userId);

        if(!doesUserExist) {
            throw new UserNotFoundException();
        }

        boolean doesSpotExist = spotLookupPort.doesSpotExist(spotId);

        if(!doesSpotExist) {
            throw new SpotNotFoundException();
        }

        SpotPersonalizationId id = new SpotPersonalizationId(userId, spotId);

        repository.findById(id)
                .ifPresent(spot -> {
                    throw new SpotPersonalizationAlreadyExistsException();
                });

        SpotPersonalization spotPersonalization = SpotPersonalization.create(id, userId, spotId, name);

        repository.save(spotPersonalization);

        return spotPersonalizationMapper.toSpotPersonalizationView(spotPersonalization);

    }

}
