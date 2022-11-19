package com.customer.management.main.fetch.db.write.csv;

import com.customer.management.config.AppContent;
import com.customer.management.dao.fetch.CustomerDataFetchingDAO;

import java.sql.SQLException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

public class FetchingDataMainClass {

    public static void main(String[] args) throws SQLException {

        // valid customer dao dao object
        CustomerDataFetchingDAO validCustomersDataFetchingDAO =
                new CustomerDataFetchingDAO("valid_customers");

        // invalid customer dao dao object
        CustomerDataFetchingDAO invalidCustomersDataFetchingDAO =
                new CustomerDataFetchingDAO("invalid_customers");

//----------------------------------using only use main thread approach----------------------------------------
        validCustomersDataFetchingDAO.fetchingDataFromDbByBatch();
//        invalidCustomersDataFetchingDAO.fetchingDataFromDbByBatch();


//----------------------------------using multi-threaded approach----------------------------------------------
        // for valid customer
//        for (int i = 0; i < AppContent.NUMBER_OF_FILE_READING_THREAD; i++) {
//            Thread thread = new Thread(validCustomersDataFetchingDAO);
//            thread.start();
//        }

        // for invalid customer
//        for (int i = 0; i < AppContent.NUMBER_OF_FILE_WRITING_THREAD; i++) {
//            Thread thread = new Thread(invalidCustomersDataFetchingDAO);
//            thread.start();
//        }

    }

}
