package com.mreapps.diceit.engine.dao;

import com.mreapps.diceit.engine.entity.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

@ContextConfiguration("classpath:engine-testContext.xml")
@TransactionConfiguration(defaultRollback = true)
public class RoleDaoTest extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    private RoleDao roleDao;

    @Before
    public void setupRoles()
    {
        roleDao.addRole(createRole("U", "User"));
        roleDao.addRole(createRole("A", "Admin"));
    }

    @Test
    public void listRoles()
    {
        Assert.assertEquals(2, roleDao.listRoles().size());
    }

    @Test
    public void deleteRole()
    {
        List<Role> initialRoles = roleDao.listRoles();
        Assert.assertEquals(2, initialRoles.size());

        roleDao.deleteRole(initialRoles.iterator().next().getId());
        Assert.assertEquals(1, roleDao.listRoles().size());
    }

    @Test
    public void addRole()
    {
        List<Role> initialRoles = roleDao.listRoles();
        Assert.assertEquals(2, initialRoles.size());

        roleDao.addRole(createRole("S", "Sales"));
        Assert.assertEquals(3, roleDao.listRoles().size());
    }

    private Role createRole(String code, String name)
    {
        Role role = new Role();
        role.setCode(code);
        role.setName(name);

        return role;
    }
}
