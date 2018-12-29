package com.student.integration.service.subject.impl;

import com.student.integration.mappers.SubjectMapper;
import com.student.integration.model.Subject;
import com.student.integration.service.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;
    @Override
    public List<Subject> getAllSubjectsOfAcademy(Long academyId) {
        return subjectMapper.getSubjects();
    }
}
