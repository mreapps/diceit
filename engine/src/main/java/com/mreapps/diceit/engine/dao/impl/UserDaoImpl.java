package com.mreapps.diceit.engine.dao.impl;

import com.mreapps.diceit.engine.dao.UserDao;
import com.mreapps.diceit.engine.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao
{
    public UserDaoImpl()
    {
        super(User.class);
    }

    @Override
    public void addUser(User user)
    {
        save(user);
    }

    @Override
    public List<User> listUsers()
    {
        return listAll();
    }

    @Override
    public void deleteUser(Integer id)
    {
        delete(id);
    }
}
