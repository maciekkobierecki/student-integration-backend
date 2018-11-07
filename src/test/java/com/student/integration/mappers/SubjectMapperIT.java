package com.student.integration.mappers;

import com.student.integration.ApplicationTests;
import com.student.integration.model.Semester;
import com.student.integration.model.Subject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectMapperIT extends ApplicationTests {
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    public void checkValidityOfCrudOperations(){
        Subject subject = new Subject();
        subject.setSubjectName("name");
        subject.setDisplayName("displayName");
        subject.setSubjectNameShort("shortname");
        subject.setAcademyId(12L);
        subjectMapper.insertSubject(subject);
        Subject result = subjectMapper.getSubject(subject.getId());
        subjectMapper.updateSubject(result);
        subjectMapper.deleteSubject(result.getId());
    }
}
