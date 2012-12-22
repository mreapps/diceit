package com.mreapps.diceit.engine.dao;

import com.mreapps.diceit.engine.entity.Role;

import java.util.List;

public interface RoleDao
{
    void addRole(Role role);

    List<Role> listRoles();

    void deleteRole(Integer id);
}
