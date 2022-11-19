package com.customer.management.main.read.txt.write.db;

import com.customer.management.config.AppContent;
import com.customer.management.dao.save.InvalidCustomerDAO;
import com.customer.management.dao.save.ValidCustomerDAO;
import com.customer.management.entity.Customer;
import com.customer.management.service.convert.DataSplitToCustomer;
import com.customer.management.service.validation.ContactAndEmailValidation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class ThreadPoolMain {

    public static void main(String[] args) throws IOException {
        DataReader reader = new DataReader(AppContent.FILE_NAME, 10);
        reader.start();
    }

    private static class DataReader implements Runnable {
        private final BufferedReader bufferedReader;
        private final int threadCount;

        public DataReader(String path, int threadCount) throws FileNotFoundException {
            this.bufferedReader = new BufferedReader(new FileReader(path));
            this.threadCount = threadCount;
        }

        public void start() throws IOException {
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            for (int i = 0; i < threadCount; i++) {
                executor.submit(this);
            }
            executor.shutdown();
        }

        ContactAndEmailValidation validation = new ContactAndEmailValidation();
        DataSplitToCustomer splitToCustomer = new DataSplitToCustomer();
        ValidCustomerDAO validCustomerDAO = new ValidCustomerDAO();
        InvalidCustomerDAO invalidCustomerDAO = new InvalidCustomerDAO();

        @Override
        public void run() {
            String data;
            try {
                while ((data = bufferedReader.readLine()) != null) {

                    Customer customer = splitToCustomer.dataSplitToCustomer(data);
                    if (validation.contactAndEmailValidation(customer)) {
                        if (!validCustomerDAO.isDuplicate(customer))
                            validCustomerDAO.dataInsertConnection(customer);
                        else
                            System.out.println("Duplicate Valid Customer");
                    } else {
                        if (!invalidCustomerDAO.isDuplicate(customer))
                            invalidCustomerDAO.dataInsertConnection(customer);
                        else
                            System.out.println("Duplicate Invalid Customer");
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + customer);


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void finalize() throws Throwable {
            this.bufferedReader.close();
        }
    }

}
