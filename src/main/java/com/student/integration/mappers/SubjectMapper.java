package com.student.integration.mappers;

import com.student.integration.model.Semester;
import com.student.integration.model.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectMapper {
    List<Subject> getSubjects();

    Subject getSubject(@Param("id") Long id);

    void insertSubject(@Param("subject")Subject subject);

    void updateSubject(@Param("subject")Subject subject);

    void deleteSubject(@Param("id")Long id);
}
