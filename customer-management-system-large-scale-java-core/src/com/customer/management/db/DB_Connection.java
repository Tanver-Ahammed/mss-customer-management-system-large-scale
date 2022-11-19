package com.customer.management.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class DB_Connection {

    public static final String URL = "jdbc:mysql://127.0.0.1/customer_management?useSSL=false&allowPublicKeyRetrieval=true";

    public static final String USER = "root";

    public static final String PASSWORD = "Tanver@123";

    /**
     * This Method create a database connection from required database.
     */
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static DB_Connection dbConnection;


}
