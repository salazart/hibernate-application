package com.sz.ha.services;

import com.sz.ha.interfaces.IUserService;
import com.sz.ha.models.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertNotSame;
import static org.junit.Assert.assertEquals;

/**
 * Created by Lenovo on 06.05.2018.
 */
public class UserServiceTest {
    public static final String SYDORCHUK = "Sydorchuk";
    public static final String INNA = "Inna";

    private IUserService userService;

    @Before
    public void beforeTest(){
        Connection connection = null;
        try {
            connection = JdbcConnectionService.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        userService = new UserServiceImpl(connection);
    }

    @Test
    public void createTest() throws Exception {
        User user = createUser();
        userService.create(user);
        assertNotSame(user.getId(), Long.valueOf(0));

        if(!user.getId().equals(Long.valueOf(0)))
            userService.delete(user.getId());
    }

    @Test
    public void readTest() {
        User user = createUser();
        userService.create(user);

        User user2 = userService.read(user.getId());
        assertEquals(user, user2);

        if(!user.getId().equals(Long.valueOf(0)))
            userService.delete(user.getId());
    }

    private User createUser(){
        User user = new User();
        user.setLastName(SYDORCHUK);
        user.setFirstName(INNA);
        return user;
    }

}