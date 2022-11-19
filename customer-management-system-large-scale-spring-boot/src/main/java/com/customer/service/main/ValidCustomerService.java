package com.customer.service.main;

import com.customer.dto.CustomerDTO;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

public interface ValidCustomerService {

    CustomerDTO saveValidCustomer(CustomerDTO customerDTO);

    boolean isDuplicateCustomer(CustomerDTO customerDTO);

}
