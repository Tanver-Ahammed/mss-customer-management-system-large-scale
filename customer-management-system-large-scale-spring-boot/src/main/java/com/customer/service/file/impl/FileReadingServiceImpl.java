package com.customer.service.file.impl;

import com.customer.config.AppContent;
import com.customer.dto.CustomerDTO;
import com.customer.service.file.FileReadingService;
import com.customer.service.main.impl.ValidCustomerServiceImpl;
import com.customer.service.split.DataSplitToCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */

@Service
public class FileReadingServiceImpl implements FileReadingService {

    @Autowired
    private ValidCustomerServiceImpl validCustomerService;

    /**
     * This is file reading service
     * here we read .txt file from directory
     * For file reading purpose we use BufferedReader,
     * we also use FileReader or Scanner class
     * but it is memory efficient for large file
     *
     * @return void
     * @throws IOException
     */
    @Override
    public void fileReadingFromDirectory() {
        File file = new File(AppContent.FILE_NAME);
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            DataSplitToCustomer splitToCustomer = new DataSplitToCustomer();
            int totalCustomer = 0;
            // reading file using loop
            long startingTime = System.currentTimeMillis();
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) break;
                CustomerDTO customerDTO = splitToCustomer.dataSplitToCustomer(data);
//                System.out.println(totalCustomer + "  " + customerDTO);
                boolean isCustomerDuplicate = this.validCustomerService.isDuplicateCustomer(customerDTO);
                if (!isCustomerDuplicate)
                    this.validCustomerService.saveValidCustomer(customerDTO);
                System.err.println(isCustomerDuplicate);
                ++totalCustomer;
                ++totalCustomer;
                ++totalCustomer;
                ++totalCustomer;
            }
            long endingTime = System.currentTimeMillis();
            System.out.println(endingTime - startingTime);
            System.out.println(totalCustomer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


