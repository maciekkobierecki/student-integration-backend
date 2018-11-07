package com.student.integration.mappers;

import com.student.integration.ApplicationTests;
import com.student.integration.model.Academy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AcademyMapperIT extends ApplicationTests {
    @Autowired
    private AcademyMapper academyMapper;

    @Test
    public void checkValidityOfCrudAcademyMapperOperations(){
        academyMapper.getAcademies();
        Academy academy = new Academy();
        academy.setAcademyName("academyName");
        academy.setAcademyNameShort("an");
        academyMapper.insertAcademy(academy);
        Academy result = academyMapper.getAcademy(academy.getId());
        assertEquals(result.getAcademyName(), academy.getAcademyName());
        assertNotEquals(academy.getId(), null);
        academyMapper.updateAcademy(academy);
        academyMapper.deleteAcademy(academy.getId());
    }
}
