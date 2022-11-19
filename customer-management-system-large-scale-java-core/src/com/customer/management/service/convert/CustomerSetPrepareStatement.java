package com.customer.management.service.convert;

import com.customer.management.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class CustomerSetPrepareStatement {

    /**
     This is a converter method customer to @see ResultSet
     * to decrease code duplicate
     * @return PreparedStatement
     */


    public PreparedStatement customerSetPrepareStatement(Customer customer,
                                                         PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setString(3, customer.getCity());
        preparedStatement.setString(4, customer.getCountry());
        preparedStatement.setString(5, customer.getPostCode());
        preparedStatement.setString(6, customer.getContact());
        preparedStatement.setString(7, customer.getEmail());
        preparedStatement.setString(8, customer.getIp());
        return preparedStatement;
    }

}
