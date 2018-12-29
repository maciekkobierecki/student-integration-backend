package com.student.integration.mappers;

import com.student.integration.model.File;
import com.student.integration.model.Semester;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SemesterMapper {
    List<Semester> getSemesters();

    Semester getSemester(@Param("id") Long id);

    Long getSemesterId(@Param("degreeId") Long degreeId, @Param("semesterNo") Long semesterNo);

    void insertSemester(@Param("semester")Semester semester);

    void updateSemester(@Param("semester")Semester semester);

    void deleteSemester(@Param("id")Long id);
}
