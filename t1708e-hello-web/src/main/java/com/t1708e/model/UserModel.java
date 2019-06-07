package com.t1708e.model;

import com.t1708e.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {
    private static final String TABLE_NAME = "user";

    public boolean save(User user){
        boolean result = false;
        String sqlString = "INSERT INTO " + TABLE_NAME + "(username, password, salt, fullName, email, phone, status) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(sqlString);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSalt());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getStatus());
            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<User> getList(){
        ArrayList<User> results = new ArrayList<>();
        String sqlString = "SELECT * FROM " + TABLE_NAME;

        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(sqlString);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String salt = resultSet.getString("salt");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                User user = new User(username,password,salt,fullName,email,phone,status);
                results.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  results;
    }

    public User findUserByUsernameAndStatus(String username, User.Status status){
        String sqlString = "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND status = ?";
        User user = null;
        try {
            PreparedStatement ps = DBConnector.getConnection().prepareStatement(sqlString);
            ps.setString(1, username);
            ps.setInt(2, status.getValue());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSalt(rs.getString("salt"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setStatus(User.Status.findByValue(rs.getInt("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
