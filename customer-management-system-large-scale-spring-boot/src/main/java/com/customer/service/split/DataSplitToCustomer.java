package com.customer.service.split;

import com.customer.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class DataSplitToCustomer {

    private CustomerDTO customerDTO;

    public DataSplitToCustomer() {
    }

    public DataSplitToCustomer(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public CustomerDTO dataSplitToCustomer(String customerData) {
        CustomerDTO customerDTO = new CustomerDTO();
        String propertyData = "";
        int propertyCounter = 0;
        for (char ch : customerData.toCharArray()) {
            if (ch == ',') {
                if (propertyCounter == 0)
                    customerDTO.setFirstName(propertyData);
                else if (propertyCounter == 1)
                    customerDTO.setLastName(propertyData);
                else if (propertyCounter == 2)
                    customerDTO.setCity(propertyData);
                else if (propertyCounter == 3)
                    customerDTO.setCountry(propertyData);
                else if (propertyCounter == 4)
                    customerDTO.setPostCode(propertyData);
                else if (propertyCounter == 5)
                    customerDTO.setContact(propertyData);
                else if (propertyCounter == 6)
                    customerDTO.setEmail(propertyData);
                ++propertyCounter;
                propertyData = "";
                continue;
            }
            propertyData += ch;
        }
        customerDTO.setIp(propertyData);
        return customerDTO;
    }

}
