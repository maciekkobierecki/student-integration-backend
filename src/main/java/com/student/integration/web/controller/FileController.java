package com.student.integration.web.controller;

import com.student.integration.web.response.File;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class FileController {

    @RequestMapping(value = "/files", method= RequestMethod.GET)
    public List<File> getFiles(){
        return Collections.singletonList(new File("15", "20"));
    }
}
