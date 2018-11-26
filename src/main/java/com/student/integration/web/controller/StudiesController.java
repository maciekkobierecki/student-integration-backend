package com.student.integration.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudiesController {

    @GetMapping("/my-studies")
    public String getMyStudies(){
        return "[{\"id\":1,\"academyName\":\"PolitechnikaWarszawska\",\"academyNameShort\":\"PW\",\"semesters\":[{\"id\":1,\"name\":\"telkomunikacja3sem\",\"subjects\":[{\"id\":1,\"name\":\"Elektronika\"},{\"id\":2,\"name\":\"Programowaniezdarzeniowe\"}]},{\"id\":2,\"name\":\"telkomunikacja3sem\",\"subjects\":[{\"id\":3,\"name\":\"Elektronika\"},{\"id\":4,\"name\":\"Programowaniezdarzeniowe\"}]}]},{\"id\":2,\"academyName\":\"UniwersytetWarszawski\",\"academyNameShort\":\"UW\",\"semesters\":[{\"id\":1,\"name\":\"prawo1sem\",\"subjects\":[{\"id\":1,\"name\":\"prawocywilne\"},{\"id\":2,\"name\":\"prawokarne\"}]},{\"id\":2,\"name\":\"politologia\",\"subjects\":[{\"id\":3,\"name\":\"naukaugównie\"},{\"id\":4,\"name\":\"analizapierdówmickiewicza\"}]}]}]";
    }
}
