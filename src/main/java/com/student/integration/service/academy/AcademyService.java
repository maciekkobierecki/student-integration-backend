package com.student.integration.service.academy;

import com.student.integration.model.Academy;

import java.util.List;

public interface AcademyService {
    public List<Academy> getAcademies();

    public void saveAcademy(Academy academy);
}
