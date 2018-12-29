package com.student.integration.web.controller;

import com.student.integration.model.Degree;
import com.student.integration.service.degree.UniversityDegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UniversityDegreeController {
    private final UniversityDegreeService universityDegreeService;

    @GetMapping("api/academies/{academyId}/degrees")
    public List<Degree> getDegreesByAcademy(@PathVariable Long academyId){
        return universityDegreeService.getDegrees(academyId);
    }
}
