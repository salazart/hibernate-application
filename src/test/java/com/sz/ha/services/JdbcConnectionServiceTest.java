package com.sz.ha.services;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by lenovo on 02.05.2018.
 */
public class JdbcConnectionServiceTest {

    @Test
    public void getInstance() {
        JdbcConnectionService jdbcConnectionService = JdbcConnectionService.getInstance();
        assertNotNull(jdbcConnectionService);
    }

    @Test
    public void getConnection() {
        try {
            Connection connection = JdbcConnectionService.getInstance().getConnection();
            assertNotNull(connection);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}