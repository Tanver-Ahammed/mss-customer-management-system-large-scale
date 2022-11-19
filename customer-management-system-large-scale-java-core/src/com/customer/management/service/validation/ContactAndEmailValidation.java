package com.customer.management.service.validation;

import com.customer.management.entity.Customer;
import com.customer.management.service.convert.DataSplitToCustomer;

import java.util.regex.Pattern;

public class ContactAndEmailValidation {

    public boolean contactAndEmailValidation(Customer customer) {
        String contactRegex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        final String emailRegex = "^[A-Za-z0-9_.-]+@[A-Za-z0-9.-]+$";
        Pattern contactPattern = Pattern.compile(contactRegex);
        Pattern emailPattern = Pattern.compile(emailRegex);

        if (customer.getContact().startsWith("+2")) {
            customer.setContact(customer.getContact().substring(3));
        }
        if (!contactPattern.matcher(customer.getContact()).matches())
            return false;
        return emailPattern.matcher(customer.getEmail()).matches();
    }

    public static void main(String[] args) {
        Customer customer = new DataSplitToCustomer().dataSplitToCustomer
                ("Robert,Branch,Haines city,FL,33844,40(746)86162,rbranch@pacbell.net,65.215.76.5");

        System.out.println(new ContactAndEmailValidation().contactAndEmailValidation(customer));

    }

}
