package com.mreapps.diceit.engine.dao;

import com.mreapps.diceit.engine.entity.User;
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
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    private UserDao userDao;

    @Before
    public void setupUsers()
    {
        userDao.addUser(createUser("esi", "ewddwdqwe", "Espen", "Simensen", "espen.simensen@broadpark.no", "+4795731327"));
        userDao.addUser(createUser("ves", "ewddwdqwe", "Vetle", "Enger Simensen", "", ""));
    }

    @Test
    public void listUsers()
    {
        Assert.assertEquals(2, userDao.listUsers().size());
    }

    @Test
    public void deleteUser()
    {
        List<User> initialUsers = userDao.listUsers();
        Assert.assertEquals(2, initialUsers.size());

        userDao.deleteUser(initialUsers.iterator().next().getId());
        Assert.assertEquals(1, userDao.listUsers().size());
    }

    @Test
    public void addUser()
    {
        List<User> initialUsers = userDao.listUsers();
        Assert.assertEquals(2, initialUsers.size());

        userDao.addUser(createUser("mes", "wesscasd", "Mathilde", "Enger Simensen", "", ""));
        Assert.assertEquals(3, userDao.listUsers().size());
    }

    private User createUser(String username, String encryptedPassword, String firstname, String lastname, String email, String phoneNumber)
    {
        User user = new User();
        user.setUsername(username);
        user.setEncryptedPassword(encryptedPassword);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        return user;
    }
}
