package com.amadeus.mapper;

import com.amadeus.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectById(int id);
}
