package com.student.integration.mappers;

import com.student.integration.ApplicationTests;
import com.student.integration.model.File;
import com.student.integration.model.Semester;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SemesterMapperIT extends ApplicationTests {
    @Autowired
    private SemesterMapper semesterMapper;

    @Test
    public void checkValidityOfCrudOperations(){
        Semester semester = new Semester();
        semester.setSemesterName("name");
        semesterMapper.insertSemester(semester);
        Semester result = semesterMapper.getSemester(semester.getId());
        semesterMapper.updateSemester(result);
        semesterMapper.deleteSemester(result.getId());
    }
}
