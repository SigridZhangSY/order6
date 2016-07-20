package com.thoughtworks.ketsu.infrastructure.core;


import java.util.Map;

public interface UserRepository {
    User createUser(Map<String, Object> info);
}
