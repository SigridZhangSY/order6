package com.thoughtworks.ketsu.infrastructure.repository;

import com.thoughtworks.ketsu.infrastructure.core.User;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by syzhang on 7/20/16.
 */
public class UserRepository implements com.thoughtworks.ketsu.infrastructure.core.UserRepository {

    @Inject
    UserMapper userMapper;

    @Override
    public User createUser(Map<String, Object> info) {
        userMapper.save(info);
        return userMapper.findById(Long.valueOf(String.valueOf(info.get("id"))));
    }
}
