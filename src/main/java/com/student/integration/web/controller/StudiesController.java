package com.student.integration.web.controller;

import com.student.integration.security.SiUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudiesController {

    @GetMapping("/api/my-studies")
    public String getMyStudies(@AuthenticationPrincipal SiUserDetails userDetails){
        return "[{\"id\":1,\"academyName\":\"PolitechnikaWarszawska\",\"academyNameShort\":\"PW\",\"semesters\":[{\"id\":1,\"name\":\"ELektronika 3 semestr\",\"subjects\":[{\"id\":1,\"name\":\"Elektronika\"},{\"id\":2,\"name\":\"Programowanie zdarzeniowe\"}]},{\"id\":2,\"name\":\"Telkomunikacja 2 semestr\",\"subjects\":[{\"id\":3,\"name\":\"Elektronika\"},{\"id\":4,\"name\":\"Programowanie zdarzeniowe\"}]}]},{\"id\":2,\"academyName\":\"UniwersytetWarszawski\",\"academyNameShort\":\"UW\",\"semesters\":[{\"id\":1,\"name\":\"prawo1sem\",\"subjects\":[{\"id\":5,\"name\":\"prawocywilne\"},{\"id\":6,\"name\":\"prawokarne\"}]},{\"id\":7,\"name\":\"politologia\",\"subjects\":[{\"id\":7,\"name\":\"nauka o pelikanach\"},{\"id\":8,\"name\":\"analiza rozpiętości skrzydeł\"}]}]}]";
    }
}
