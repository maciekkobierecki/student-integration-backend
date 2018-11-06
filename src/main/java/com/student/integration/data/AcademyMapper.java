package com.student.integration.data;

import com.student.integration.model.entity.Academy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcademyMapper {

    List<Academy> getAcademies();


}
