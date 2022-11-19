package com.customer.management.dao.save;

import com.customer.management.db.DB_Connection;
import com.customer.management.entity.Customer;
import com.customer.management.service.convert.CustomerSetPrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class InvalidCustomerDAO {

    Connection connection = DB_Connection.getConnection();

    PreparedStatement preparedStatement = null;

    /**
     * This method is used insert data in the database.
     * */
    public void dataInsertConnection(Customer customer) {
        final String SQL = "INSERT INTO invalid_customers (first_name, last_name, city," +
                " country, post_code, contact, email, ip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            synchronized (this) {
                preparedStatement = connection.prepareStatement(SQL);
                this.preparedStatement = new CustomerSetPrepareStatement()
                        .customerSetPrepareStatement(customer, preparedStatement);
                int affectedRow = preparedStatement.executeUpdate();
                System.out.println(affectedRow);
                this.preparedStatement.close();
                this.connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This Method is not Argent. If we contact & email field UNIQUE
     * in database & catch the Exception Solved the issue.
     * */
    public boolean isDuplicate(Customer customer) {
        final String SQL = "SELECT COUNT(*) AS total FROM invalid_customers WHERE contact = ? or email = ?";
        try {
            synchronized (this) {
                preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, customer.getContact());
                preparedStatement.setString(2, customer.getEmail());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                    if (resultSet.getInt(1) > 0)
                        return true;
            }
            this.preparedStatement.close();
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
