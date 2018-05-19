package com.sz.ha.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lenovo on 02.05.2018.
 */
public class JdbcConnectionService {
    private static final String URL_CONNECTION = "jdbc:h2:~/test";
    private static final String USER_CONNECTION = "sa";
    private static final String PASS_CONNECTION = "";

    private static volatile JdbcConnectionService jdbcConnectionService;

    private static volatile Connection connection;

    private JdbcConnectionService(){}

    public static JdbcConnectionService getInstance(){
        if(jdbcConnectionService == null){
            jdbcConnectionService = new JdbcConnectionService();
        }
        return jdbcConnectionService;
    }

    public Connection getConnection() throws SQLException {
        return (connection == null || connection.isClosed()) ?
                createConnection()
                : connection;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL_CONNECTION, USER_CONNECTION, PASS_CONNECTION);
    }

}
