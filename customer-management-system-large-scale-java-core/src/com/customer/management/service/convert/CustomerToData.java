package com.customer.management.service.convert;

import com.customer.management.entity.Customer;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class CustomerToData {

    /**
     * This is a converter Customer to Customer string
     *
     * @return String
     */
    public String customerToData(Customer customer) {
        String customerData = "";
        customerData += customer.getId() + ",";
        customerData += customer.getFirstName() + ",";
        customerData += customer.getLastName() + ",";
        customerData += customer.getCity() + ",";
        customerData += customer.getCountry() + ",";
        customerData += customer.getPostCode() + ",";
        customerData += customer.getContact() + ",";
        customerData += customer.getEmail() + ",";
        customerData += customer.getIp() + "\n";
        return customerData;
    }

}
