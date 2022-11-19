package com.customer.management.main.read.txt.write.db;

import com.customer.management.service.file.FileReadAndSaveDB;

import java.io.IOException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class MainClass {
    public static void main(String[] args) throws IOException {

        /**
         * here we use only one object in thread
         * so we the thread multi-threaded way but
         * only file call one times because one object
         */
        FileReadAndSaveDB fileReading = new FileReadAndSaveDB();

        // single Thread
        fileReading.readingFIleLineByLine();

        // multi-thread
//        for (int i = 0; i < AppContent.NUMBER_OF_FILE_READING_THREAD; i++) {
//            Thread thread = new Thread(fileReading);
//            thread.start();
//        }

//        File file = new File(AppContent.FILE_NAME);
//        FileReader fileReader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        ContactAndEmailValidation validation = new ContactAndEmailValidation();
//
//        BlockingQueue<Customer> customerBlockingQueues = new ArrayBlockingQueue<>(1000);
//        DataSplitToCustomer splitToCustomer = new DataSplitToCustomer();
//        ValidCustomerDAO customerDAO = new ValidCustomerDAO();
//        while (true) {
//            String data = bufferedReader.readLine();
//            if (data == null) break;
//            Customer customer = splitToCustomer.dataSplitToCustomer(data);
//            if (validation.contactAndEmailValidation(customer)) {
//                customerBlockingQueues.add(customer);
//            }
//        }


    }
}
