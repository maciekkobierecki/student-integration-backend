package com.student.integration.mappers;

import com.student.integration.model.Degree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DegreeMapper {
    List<Degree> getDegrees(Long academyId);
}
