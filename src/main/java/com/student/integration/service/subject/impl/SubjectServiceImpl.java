package com.student.integration.service.subject.impl;

import com.student.integration.mappers.SubjectMapper;
import com.student.integration.model.Subject;
import com.student.integration.model.SubjectComment;
import com.student.integration.model.SubjectDetails;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.subject.SubjectService;
import com.student.integration.web.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;

    @Override
    public List<Subject> getAllSubjectsOfAcademy(Long academyId) {
        return null;
    }

    @Override
    public List<Subject> getSubjectsBoundToDegree(Long degreeId) {
        return null;
    }

    @Override
    public List<Subject> getSubjects(Pagination pagination) {
        return subjectMapper.getSubjects(pagination);
    }

    @Override
    @Transactional
    public void markSubject(SubjectDetails subjectDetails, Boolean isPositiveGrade, SiUserDetails userDetails) {
        Long id = subjectDetails.getId();
        if (isPositiveGrade) {
            subjectMapper.markSubjectPositive(id);
            subjectDetails.setRating(subjectDetails.getRating() + 1);
        } else {
            subjectMapper.markSubjectNegative(id);
        }
        subjectDetails.setRatingCount(subjectDetails.getRatingCount() + 1);
        subjectMapper.userMarkedSubject(id, userDetails.getId());
        subjectDetails.setIsMarkable(false);
    }

    @Override
    public SubjectDetails getSubjectDetails(Long id, SiUserDetails userDetails) {
        return subjectMapper.getSubjectDetails(id, userDetails.getId());
    }

    @Override
    public List<SubjectComment> getSubjectComments(Long id) {
        return subjectMapper.getSubjectComments(id);
    }

    @Override
    public void addNewComment(Long id, String content, Boolean isAnonymous, SiUserDetails userDetails) {
        subjectMapper.addComment(id, content, isAnonymous, userDetails.getId());
    }
}
