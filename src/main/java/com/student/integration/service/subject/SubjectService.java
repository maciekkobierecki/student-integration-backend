package com.student.integration.service.subject;

import com.student.integration.model.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> getAllSubjectsOfAcademy(Long academyId);
}
