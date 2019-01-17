package com.student.integration.service.subject;

import com.student.integration.model.Subject;
import com.student.integration.model.SubjectComment;
import com.student.integration.model.SubjectDetails;
import com.student.integration.security.SiUserDetails;
import com.student.integration.web.Pagination;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjectsOfAcademy(Long academyId);
    List<Subject> getSubjectsBoundToDegree(Long degreeId);
    List<Subject> getSubjects(Pagination pagination);
    void markSubject(SubjectDetails subjectDetails, Boolean isPositiveGrade, SiUserDetails userDetails);
    SubjectDetails getSubjectDetails(Long id, SiUserDetails userDetails);
    List<SubjectComment> getSubjectComments(Long id);
    void addNewComment(Long id, String content, Boolean isAnonymous, SiUserDetails userDetails);

}
