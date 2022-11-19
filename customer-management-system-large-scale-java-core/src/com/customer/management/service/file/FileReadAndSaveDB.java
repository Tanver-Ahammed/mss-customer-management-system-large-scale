package com.customer.management.service.file;

import com.customer.management.config.AppContent;
import com.customer.management.dao.save.InvalidCustomerDAO;
import com.customer.management.dao.save.ValidCustomerDAO;
import com.customer.management.entity.Customer;
import com.customer.management.service.convert.DataSplitToCustomer;
import com.customer.management.service.validation.ContactAndEmailValidation;

import java.io.*;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

public class FileReadAndSaveDB implements Runnable {

    File file = new File(AppContent.FILE_NAME);
    FileReader fileReader;
    BufferedReader bufferedReader;

    public FileReadAndSaveDB() throws FileNotFoundException {
        this.fileReader = new FileReader(file);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public void readingFIleLineByLine() throws IOException {
//        Thread currentThread = Thread.currentThread();
        DataSplitToCustomer splitToCustomer = new DataSplitToCustomer();
        ContactAndEmailValidation validation = new ContactAndEmailValidation();
        ValidCustomerDAO validCustomerDAO = new ValidCustomerDAO();
        InvalidCustomerDAO invalidCustomerDAO = new InvalidCustomerDAO();
        while (true) {
            String data = bufferedReader.readLine();
            if (data == null) break;
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
    }


    @Override
    public void run() {
        try {
            readingFIleLineByLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}