package com.customer.service.main.impl;

import com.customer.dto.CustomerDTO;
import com.customer.entities.ValidCustomer;
import com.customer.repository.ValidCustomerRepository;
import com.customer.service.main.ValidCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

@Service
public class ValidCustomerServiceImpl implements ValidCustomerService {

    @Autowired
    private ValidCustomerRepository validCustomerRepository;

    @Override
    public CustomerDTO saveValidCustomer(CustomerDTO customerDTO) {
        ValidCustomer validCustomer = this.dtoToValidCustomer(customerDTO);
        return this.validCustomerTODTO(this.validCustomerRepository.save(validCustomer));
    }

    @Override
    public boolean isDuplicateCustomer(CustomerDTO customerDTO) {
        return this.validCustomerRepository.existsByContactOrEmail
                (customerDTO.getContact(), customerDTO.getEmail());
    }

    public CustomerDTO validCustomerTODTO(ValidCustomer validCustomer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(validCustomer.getId());
        customerDTO.setFirstName(validCustomer.getFirstName());
        customerDTO.setLastName(validCustomer.getLastName());
        customerDTO.setCity(validCustomer.getCity());
        customerDTO.setCountry(validCustomer.getCountry());
        customerDTO.setPostCode(validCustomer.getPostCode());
        customerDTO.setContact(validCustomer.getContact());
        customerDTO.setEmail(validCustomer.getEmail());
        customerDTO.setIp(validCustomer.getIp());
        return customerDTO;
    }

    public ValidCustomer dtoToValidCustomer(CustomerDTO customerDTO) {
        ValidCustomer validCustomer = new ValidCustomer();
        validCustomer.setId(customerDTO.getId());
        validCustomer.setFirstName(customerDTO.getFirstName());
        validCustomer.setLastName(customerDTO.getLastName());
        validCustomer.setCity(customerDTO.getCity());
        validCustomer.setCountry(customerDTO.getCountry());
        validCustomer.setPostCode(customerDTO.getPostCode());
        validCustomer.setContact(customerDTO.getContact());
        validCustomer.setEmail(customerDTO.getEmail());
        validCustomer.setIp(customerDTO.getIp());
        return validCustomer;
    }

}
