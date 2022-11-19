package com.customer;

import com.customer.dto.CustomerDTO;
import com.customer.service.file.FileReadingService;
import com.customer.service.file.impl.FileReadingServiceImpl;
import com.customer.service.split.DataSplitToCustomer;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
    public static void main(String[] args) {

        FileReadingService fileReading = new FileReadingServiceImpl();
        fileReading.fileReadingFromDirectory();

        System.out.println("---------------------------------------------------------------------------------------");

        DataSplitToCustomer customer = new DataSplitToCustomer();
        CustomerDTO customerDTO = customer.dataSplitToCustomer("Robert,Branch,Haines city,FL,33844,4074686162,rbranch@pacbell.net,65.215.76.5");
        System.out.println(customerDTO);

    }

}
