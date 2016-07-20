package com.thoughtworks.ketsu.infrastructure.mybatis.mappers;


import com.thoughtworks.ketsu.infrastructure.core.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    int save(@Param("info")Map<String, Object> info);

    User findById(@Param("id") long id);
}
