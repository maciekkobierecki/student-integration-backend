package com.student.integration.mappers;

import com.student.integration.model.Semester;
import com.student.integration.model.Subject;
import com.student.integration.model.SubjectComment;
import com.student.integration.model.SubjectDetails;
import com.student.integration.web.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {
    List<Subject> getSubjects(@Param("pagination")Pagination pagination);

    Subject getSubject(@Param("id") Long id);

    void insertSubject(@Param("subject")Subject subject);

    void updateSubject(@Param("subject")Subject subject);

    void deleteSubject(@Param("id")Long id);

    void markSubjectPositive(@Param("id")Long id);

    void markSubjectNegative(@Param("id")Long id);

    void userMarkedSubject(@Param("id")Long id, @Param("userId")Long userId);

    SubjectDetails getSubjectDetails(@Param("id")Long id, @Param("userId") Long userId);

    List<SubjectComment> getSubjectComments(@Param("id") Long id);

    void addComment(@Param("id")Long id, @Param("content") String content, @Param("isAnonymous")Boolean isAnonymous, @Param("userId")Long userId);
}
