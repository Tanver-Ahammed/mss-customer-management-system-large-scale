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
public class ValidCustomerDAO {

    Connection connection = DB_Connection.getConnection();

    PreparedStatement preparedStatement = null;

    private static final String INSERTION_SQL = "INSERT INTO valid_customers (first_name, last_name, city," +
            " country, post_code, contact, email, ip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SEARCH_SQL = "SELECT COUNT(*) AS total FROM valid_customers WHERE contact = ? or email = ?";

    /**
     * This method is used insert data in the database.
     * */
    public void dataInsertConnection(Customer customer) {

        try {
            synchronized (this) {
                preparedStatement = connection.prepareStatement(this.INSERTION_SQL);
                this.preparedStatement = new CustomerSetPrepareStatement()
                        .customerSetPrepareStatement(customer, preparedStatement);
                int affectedRow = preparedStatement.executeUpdate();
                System.out.println(affectedRow);
                this.preparedStatement.close();
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This Method is not Argent. If we contact & email field UNIQUE
     * in database & catch the Exception Solved the issue.
     * */
    public boolean isDuplicate(Customer customer) {
        try {
            synchronized (this) {
                preparedStatement = connection.prepareStatement(this.SEARCH_SQL);
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
