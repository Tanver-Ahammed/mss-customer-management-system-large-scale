package com.customer.management.thread;

import com.customer.management.db.DB_Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class DBThread extends Thread {

    @Override
    public void run() {
        Connection connection = DB_Connection.getConnection();
        Random random = new Random();
        PreparedStatement preparedStatement;

        String sql = "INSERT INTO valid_customer (first_name, last_name, city, country, post_code, " +
                "contact, email, ip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            for (int i = 0; i < 1000000; i++) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, random.toString());
                preparedStatement.setString(2, random.toString());
                preparedStatement.setString(3, random.toString());
                preparedStatement.setString(4, random.toString());
                preparedStatement.setString(5, random.toString());
                preparedStatement.setString(6, random.toString());
                preparedStatement.setString(7, random.toString());
                preparedStatement.setString(8, random.toString());
                System.out.println(preparedStatement.executeUpdate());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
