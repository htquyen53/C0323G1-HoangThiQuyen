package com.user_management.repository;

import com.user_management.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "INSERT INTO users(name, email, country) VALUES(?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country FROM users WHERE id=?";
    private static final String SELECT_USERS = "SELECT * FROM users";
    private static final String DELETE_USER_SQL = "delete from users where id = ?";
    private static final String UPDATE_USER_SQL = "UPDATE date users set name = ?, email = ?, country = ? where id = ?";
    private static final String SELECT_USERS_BY_COUNTRY = "SELECT id, name, email FROM users WHERE country=?";
    private static final String SORT_BY_NAME = "SELECT * FROM users ODER BY name ASC";

    @Override
    public void insertUser(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USER_BY_ID);
            String name;
            String email;
            String country;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USERS);
            int id;
            String name;
            String email;
            String country;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                country = resultSet.getString("country");
                users.add(new User(id, name, email, country));
                System.out.println(id);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public List<User> searchByCountry(String country) {
        List<User> users = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_USERS_BY_COUNTRY);
            int id;
            String name;
            String email;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                users.add(new User(id, name, email, country));
            } connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SORT_BY_NAME);
            int id;
            String name;
            String email;
            String country;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                country = resultSet.getString("country");
                userList.add(new User(id, name, email, country));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
