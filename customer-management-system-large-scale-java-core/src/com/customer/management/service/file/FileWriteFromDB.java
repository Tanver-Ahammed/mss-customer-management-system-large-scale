package com.customer.management.service.file;

import com.customer.management.config.AppContent;
import com.customer.management.entity.Customer;
import com.customer.management.service.convert.CustomerToData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class FileWriteFromDB {

    static int fileNumber = 1;
    String fullFileDirAndName;

    public String fileWriteCSVFile(Customer customer, String fileName) throws IOException {
        if (fileName == null || fileName.equals("")) {
            fileName = createNewFile();
        }
        this.fullFileDirAndName = AppContent.WRITING_FILE_DIR + fileName;
        Path path = Path.of(fullFileDirAndName);
        long fileLength = Files.size(path);
        if (fileLength > (100000 - 75)) {
            fileName = createNewFile();
        }
        this.fullFileDirAndName = AppContent.WRITING_FILE_DIR + fileName;
        File file = new File(this.fullFileDirAndName);
        // FileWriter
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(new CustomerToData().customerToData(customer));
        fileWriter.close();

        System.out.println(fileLength);
        return fileName;
    }

    private String createNewFile() {
        File file;
        String fileName = "Customer-" + fileNumber + "-" + stringGenerator() + ".csv";
        this.fullFileDirAndName = AppContent.WRITING_FILE_DIR + fileName;
        file = new File(this.fullFileDirAndName);
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("id,first_name,last_name,city,country,post_code,contact,email,ip\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ++fileNumber;
        if (fileNumber > Integer.MAX_VALUE - 1)
            fileNumber = 0;
        return fileName;
    }

    private String stringGenerator() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
