package com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeaccesspolicy;

import com.ppublica.stargazer.spotmetadataservice.spotmetadata.application.usecase.removeamenity.RemoveAmenityCommand;

public interface RemoveAccessPolicyUseCase {
    void handle(RemoveAccessPolicyCommand command);
}
