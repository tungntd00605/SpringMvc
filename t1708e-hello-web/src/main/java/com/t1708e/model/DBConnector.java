package com.t1708e.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection;
    private static final String DB_NAME = "t1708e_java_web";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/t1708e_java_web", "root", "" );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
