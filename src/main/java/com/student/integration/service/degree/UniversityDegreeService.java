package com.student.integration.service.degree;

import com.student.integration.model.Degree;

import java.util.List;

public interface UniversityDegreeService {
    public List<Degree> getDegrees(Long academyId);
}
