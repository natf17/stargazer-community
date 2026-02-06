package com.ppublica.stargazer.spotpersonalizationservice.spotpersonalization.application.port.user;

import com.ppublica.stargazer.sharedkerneluser.UserId;

public interface UserLookupPort {
    boolean doesUserExist(UserId userId);
}
