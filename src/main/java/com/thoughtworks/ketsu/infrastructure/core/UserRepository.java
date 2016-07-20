package com.thoughtworks.ketsu.infrastructure.core;


import java.util.Map;
import java.util.Optional;

public interface UserRepository {
    User createUser(Map<String, Object> info);

    Optional<User> findUserById(long userId);
}
