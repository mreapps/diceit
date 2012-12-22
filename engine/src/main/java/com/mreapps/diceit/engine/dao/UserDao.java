package com.mreapps.diceit.engine.dao;

import com.mreapps.diceit.engine.entity.User;

import java.util.List;

public interface UserDao
{
    void addUser(User user);

    List<User> listUsers();

    void deleteUser(Integer id);
}
