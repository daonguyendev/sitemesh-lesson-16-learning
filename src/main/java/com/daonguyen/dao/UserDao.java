package com.daonguyen.dao;

import com.daonguyen.entity.User;
import com.daonguyen.jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class UserDao {

    private List<User> users = null;

    public List<User> findAllOfUsers() {
        List<User> users = new LinkedList<>();

        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "SELECT * FROM users;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("fullname"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setAvatar(resultSet.getString("avatar"));
                user.setRoleId(resultSet.getInt("role_id"));
                users.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public User findUserById(int id) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "SELECT * FROM users WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("fullname"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setAvatar(resultSet.getString("avatar"));
                user.setRoleId(resultSet.getInt("role_id"));
                return user;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new User();
    }

    public void add(User user) {
        try {
            if(user.getId() != null) {
                System.out.println("User with id [" + user.getId() + "] is existed.");
                return;
            }

            Connection connection = JDBCConnection.getConnection();
            String query = "INSERT INTO users(email, password, fullname, address, phone, avatar, role_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAvatar());
            preparedStatement.setInt(7, user.getRoleId());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Added user id [" + user.getId() + "] successfully");
            } else {
                System.out.println("Failed to insert user id [" + user.getId() + "].");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(User user) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "UPDATE users SET email = ?, password = ?, fullname = ?, address = ?, phone = ?, avatar = ?, role_id = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getAvatar());
            preparedStatement.setInt(7, user.getRoleId());
            preparedStatement.setInt(8, user.getId());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Edited user id [" + user.getId() + "] successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Integer id) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            if(statement.executeUpdate() > 0) {
                System.out.println("Removed user id [" + id + "] successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
