package com.student.integration.service.academy;

import com.student.integration.model.entity.Academy;

import java.util.List;

public interface AcademyService {
    public List<Academy> getAcademies();

    public void saveAcademy(String academyName, String academyShortName);
}
