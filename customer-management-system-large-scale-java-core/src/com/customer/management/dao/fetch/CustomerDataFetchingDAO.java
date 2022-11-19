package com.customer.management.dao.fetch;

import com.customer.management.db.DB_Connection;
import com.customer.management.entity.Customer;
import com.customer.management.service.file.FileWriteFromDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

/**
 * This is Thread Class
 */
public class CustomerDataFetchingDAO implements Runnable {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public static String FETCH_SQL = "SELECT * FROM ";
    private int fetchSize = 5000;
    int index = 0;

    static String fileName = "";

    public CustomerDataFetchingDAO(String fetchTableName) throws SQLException {
        this.connection = DB_Connection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(FETCH_SQL + fetchTableName);
        this.preparedStatement.setFetchSize(fetchSize);
        this.resultSet = this.preparedStatement.executeQuery();
    }

    /**
     * This method is used fetching data in the database batch-wise.
     * This is synchronized Method for locked an object
     */
    public void fetchingDataFromDbByBatch() {
        try {
            synchronized (this) {
                Customer customer = new Customer();
                FileWriteFromDB fileWriteFromDB = new FileWriteFromDB();
                while (this.resultSet.next()) {
                    ++index;
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("first_name"));
                    customer.setLastName(resultSet.getString("last_name"));
                    customer.setCity(resultSet.getString("city"));
                    customer.setCountry(resultSet.getString("country"));
                    customer.setPostCode(resultSet.getString("post_code"));
                    customer.setContact(resultSet.getString("contact"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setIp(resultSet.getString("ip"));
                    fileName = fileWriteFromDB.fileWriteCSVFile(customer, fileName);
                }
                this.resultSet.close();
                this.preparedStatement.close();
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.print("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        fetchingDataFromDbByBatch();
    }

}
