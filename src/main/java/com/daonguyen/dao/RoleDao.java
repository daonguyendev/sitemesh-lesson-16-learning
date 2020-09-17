package com.daonguyen.dao;

import com.daonguyen.entity.Role;
import com.daonguyen.jdbc.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class RoleDao {

    private List<Role> roles = null;

    public List<Role> findAllOfRoles() {
        List<Role> roles = new LinkedList<>();

        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "SELECT * FROM roles;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Role user = new Role();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDescription(resultSet.getString("description"));
                roles.add(user);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roles;
    }

    public Role findRoleById(int id) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "SELECT * FROM roles WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setDescription(resultSet.getString("description"));
                return role;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Role();
    }

    public void add(Role role) {
        try {

            if(role.getId() != null) {
                System.out.println("Role with id [" + role.getId() + "] is existed.");
                return;
            }

            Connection connection = JDBCConnection.getConnection();
            String query = "INSERT INTO roles(name, description) VALUES(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, role.getName());
            preparedStatement.setString(2, role.getDescription());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Added role id [" + role.getId() + "] successfully");
            } else {
                System.out.println("Failed to insert role id [" + role.getId() + "].");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit(Role role) {
        System.out.println("id=" + role.getId());
        System.out.println("name=" + role.getName());
        System.out.println("desc=" + role.getDescription());

        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, role.getName());
            preparedStatement.setString(2, role.getDescription());
            preparedStatement.setInt(3, role.getId());

            if(preparedStatement.executeUpdate() > 0) {
                System.out.println("Edited role id [" + role.getId() + "] successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Integer id) {
        try {
            Connection connection = JDBCConnection.getConnection();
            String query = "DELETE FROM roles WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            if(statement.executeUpdate() > 0) {
                System.out.println("Removed role id [" + id + "] successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
