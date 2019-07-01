package com.inspur.shardingsphere.mybatis.repository;

import com.inspur.shardingsphere.mybatis.entity.User;

import java.util.Map;

public interface UserRepository extends CommonRepository<User, Long> {

    Map selectOne();
}
