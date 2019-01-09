package com.student.integration.web.controller;

import com.student.integration.model.Academy;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.academy.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AcademyController {
    private final AcademyService academyService;

    @GetMapping("/api/academies")
    public List<Academy> getAcademies(@AuthenticationPrincipal SiUserDetails userDetails){
        return academyService.getAcademies();
    }

    @PostMapping("/api/academies/new")
    public void addAcademy(Academy academy, @AuthenticationPrincipal SiUserDetails userDetails){
        academyService.saveAcademy(academy);
    }
}
