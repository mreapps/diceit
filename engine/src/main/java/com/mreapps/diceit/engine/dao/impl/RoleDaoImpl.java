package com.mreapps.diceit.engine.dao.impl;

import com.mreapps.diceit.engine.dao.RoleDao;
import com.mreapps.diceit.engine.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao
{
    public RoleDaoImpl()
    {
        super(Role.class);
    }

    @Override
    public void addRole(Role role)
    {
        save(role);
    }

    @Override
    public List<Role> listRoles()
    {
        return listAll();
    }

    @Override
    public void deleteRole(Integer id)
    {
        delete(id);
    }
}
