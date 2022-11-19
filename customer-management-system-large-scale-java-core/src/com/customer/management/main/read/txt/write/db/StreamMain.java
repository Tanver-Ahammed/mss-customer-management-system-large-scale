package com.customer.management.main.read.txt.write.db;

import com.customer.management.config.AppContent;
import com.customer.management.dao.save.InvalidCustomerDAO;
import com.customer.management.dao.save.ValidCustomerDAO;
import com.customer.management.entity.Customer;
import com.customer.management.service.convert.DataSplitToCustomer;
import com.customer.management.service.validation.ContactAndEmailValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class StreamMain {
    public static void main(String[] args) {

        DataSplitToCustomer splitToCustomer = new DataSplitToCustomer();
        ContactAndEmailValidation validation = new ContactAndEmailValidation();
        ValidCustomerDAO validCustomerDAO = new ValidCustomerDAO();
        InvalidCustomerDAO invalidCustomerDAO = new InvalidCustomerDAO();
        String path = AppContent.FILE_NAME;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.lines().parallel().forEach(data -> {
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
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}


