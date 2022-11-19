package com.customer.controller;

import com.customer.MainClass;
import com.customer.service.file.FileReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private FileReadingService fileReading;

    @GetMapping(path = "/read/save")
    public boolean recordReadingAndSave() {
        this.fileReading.fileReadingFromDirectory();
        return true;
    }

}
