package com.student.integration.web.controller;

import com.student.integration.model.Subject;
import com.student.integration.service.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UniversitySubjectController {
    private final SubjectService subjectService;

    //TODO: Use in Group creation page to select extra Subjets
    @GetMapping("/api/academy/{academyId}/subjects")
    public List<Subject> getSubjects(@PathVariable("academyId")Long academyId){
        return subjectService.getAllSubjectsOfAcademy(academyId);
    }

    @GetMapping("/api/degrees/{degreeId}/subjects")
    public List<Subject> getSubjectsByDegree(@PathVariable("degreeId") Long degreeId){
        return subjectService.getSubjectsBoundToDegree(degreeId);
    }
}
