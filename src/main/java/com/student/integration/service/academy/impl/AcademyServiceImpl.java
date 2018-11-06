package com.student.integration.service.academy.impl;

import com.student.integration.data.AcademyMapper;
import com.student.integration.model.entity.Academy;
import com.student.integration.repository.AcademyRepository;
import com.student.integration.service.academy.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AcademyServiceImpl implements AcademyService {
    private final AcademyRepository academyRepository;
    private final AcademyMapper academyMapper;

    @Override
    public List<Academy> getAcademies() {
        return academyMapper.getAcademies();
    }

    @Override
    public void saveAcademy(String academyName, String academyShortName) {
        Academy newAcademy = new Academy();
        newAcademy.setAcademyName(academyName);
        newAcademy.setAcademyNameShort(academyShortName);
        academyRepository.save(newAcademy);
    }
}
