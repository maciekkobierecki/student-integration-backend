package com.student.integration.service.subject;

import com.student.integration.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjectsOfAcademy(Long academyId);
    List<Subject> getSubjectsBoundToDegree(Long degreeId);
}
