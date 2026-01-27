package com.ppublica.stargazer.userservice.domain.repository;

import com.ppublica.stargazer.userservice.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    boolean doesUserExistBySubject(String subject);
    User save(User newUser);
    Optional<User> findById(String id);
}
