package com.student.integration.web.controller;

import com.student.integration.model.entity.Academy;
import com.student.integration.service.academy.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AcademyController {
    private final AcademyService academyService;

    @GetMapping("/academy/getAll")
    public List<Academy> getAcademies(){
        return academyService.getAcademies();
    }

    @PostMapping("/academy/add")
    public void addAcademy(Academy academy){
        academyService.saveAcademy("","");
    }
}
