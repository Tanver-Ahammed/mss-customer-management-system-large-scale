package com.customer.service.main.impl;

import com.customer.dto.CustomerDTO;
import com.customer.entities.InvalidCustomer;
import com.customer.repository.InvalidCustomerRepository;
import com.customer.service.main.InvalidCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

@Service
public class InvalidCustomerServiceImpl implements InvalidCustomerService {

    @Autowired
    private InvalidCustomerRepository invalidCustomerRepository;

    @Override
    public CustomerDTO saveInvalidCustomer(CustomerDTO customerDTO) {
        InvalidCustomer invalidCustomer = this.dtoToInvalidCustomer(customerDTO);
        return this.invalidCustomerTODTO(this.invalidCustomerRepository.save(invalidCustomer));
    }

    @Override
    public boolean isDuplicateCustomer(CustomerDTO customerDTO) {
        return this.invalidCustomerRepository.existsByContactOrEmail
                (customerDTO.getContact(), customerDTO.getEmail());
    }

    public CustomerDTO invalidCustomerTODTO(InvalidCustomer invalidCustomer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(invalidCustomer.getId());
        customerDTO.setFirstName(invalidCustomer.getFirstName());
        customerDTO.setLastName(invalidCustomer.getLastName());
        customerDTO.setCity(invalidCustomer.getCity());
        customerDTO.setCountry(invalidCustomer.getCountry());
        customerDTO.setPostCode(invalidCustomer.getPostCode());
        customerDTO.setContact(invalidCustomer.getContact());
        customerDTO.setEmail(invalidCustomer.getEmail());
        customerDTO.setIp(invalidCustomer.getIp());
        return customerDTO;
    }

    public InvalidCustomer dtoToInvalidCustomer(CustomerDTO customerDTO) {
        InvalidCustomer invalidCustomer = new InvalidCustomer();
        invalidCustomer.setId(customerDTO.getId());
        invalidCustomer.setFirstName(customerDTO.getFirstName());
        invalidCustomer.setLastName(customerDTO.getLastName());
        invalidCustomer.setCity(customerDTO.getCity());
        invalidCustomer.setCountry(customerDTO.getCountry());
        invalidCustomer.setPostCode(customerDTO.getPostCode());
        invalidCustomer.setContact(customerDTO.getContact());
        invalidCustomer.setEmail(customerDTO.getEmail());
        invalidCustomer.setIp(customerDTO.getIp());
        return invalidCustomer;
    }

}
