package com.sz.ha.services;

import com.sz.ha.interfaces.IUser;
import com.sz.ha.models.User;

import java.sql.*;

/**
 * Created by lenovo on 03.05.2018.
 */
public class UserService implements IUser {

    private Connection connection;

    public UserService(Connection connection) {
        this.connection = connection;
    }

    private String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTO_INCREMENT, firstName VARCHAR, lastName VARCHAR)";

    private Connection getConnection(){
        return connection;
    }

    public User create(User user) {
        String query = "INSERT INTO user VALUES(DEFAULT, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getLong(1));
                System.out.println("Entity created successfully:" + user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    public User read(Long id) {
        User user = new User();
        String query = "SELECT id, firstName, lastName FROM user WHERE id = ?;";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setId(resultSet.getLong("id"));
                System.out.println("Entity read successfully:" + user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void delete(User user) {
        String query = "DELETE FROM user WHERE id = ?;";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)){
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
            System.out.println("Entity deleted successfully:" + user);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
