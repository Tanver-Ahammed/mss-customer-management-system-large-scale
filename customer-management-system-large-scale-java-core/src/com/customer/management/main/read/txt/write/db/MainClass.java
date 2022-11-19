package com.customer.management.main.read.txt.write.db;

import com.customer.management.config.AppContent;
import com.customer.management.service.file.FileReadAndSaveDB;

import java.io.IOException;

/**
 * @Author: Md. Tanver Ahammed,
 * ICT, MBSTU
 */
public class MainClass {
    public static void main(String[] args) throws IOException {

        /**
         * here we use only one object in thread
         * so we the thread multi-threaded way but
         * only file call one times because one object
         */
        FileReadAndSaveDB fileReading = new FileReadAndSaveDB();

        // single Thread
        fileReading.readingFIleLineByLine();

        // multi-thread
        for (int i = 0; i < AppContent.NUMBER_OF_FILE_READING_THREAD; i++) {
            Thread thread = new Thread(fileReading);
            thread.start();
        }

    }
}
