package com.student.integration.service.degree.impl;

import com.student.integration.mappers.DegreeMapper;
import com.student.integration.model.Degree;
import com.student.integration.service.degree.UniversityDegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityDegreeServiceImpl implements UniversityDegreeService {
    private final DegreeMapper degreeMapper;

    @Override
    public List<Degree> getDegrees(Long academyId) {
        return degreeMapper.getDegrees(academyId);
    }
}
