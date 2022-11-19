package com.customer.management.service.convert;


import com.customer.management.entity.Customer;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class DataSplitToCustomer {

    private Customer customer;

    public DataSplitToCustomer() {
    }

    public DataSplitToCustomer(Customer customerDTO) {
        this.customer = customerDTO;
    }

    /**
     * This is a converter customer string data to Customer
     *
     * @return Customer
     */
    public Customer dataSplitToCustomer(String customerData) {
        Customer customer = new Customer();
        String propertyData = "";
        int propertyCounter = 0;
        for (char ch : customerData.toCharArray()) {
            if (ch == ',') {
                if (propertyCounter == 0)
                    customer.setFirstName(propertyData);
                else if (propertyCounter == 1)
                    customer.setLastName(propertyData);
                else if (propertyCounter == 2)
                    customer.setCity(propertyData);
                else if (propertyCounter == 3)
                    customer.setCountry(propertyData);
                else if (propertyCounter == 4)
                    customer.setPostCode(propertyData);
                else if (propertyCounter == 5)
                    customer.setContact(propertyData);
                else if (propertyCounter == 6)
                    customer.setEmail(propertyData);
                ++propertyCounter;
                propertyData = "";
                continue;
            }
            propertyData += ch;
        }
        customer.setIp(propertyData);
        return customer;
    }

}
