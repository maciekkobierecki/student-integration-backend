package com.student.integration.mappers;

import com.student.integration.model.Academy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AcademyMapper {

    List<Academy> getAcademies();

    Academy getAcademy(@Param("id") Long id);

    void insertAcademy(@Param("academy")Academy academy);

    void updateAcademy(@Param("academy")Academy academy);

    void deleteAcademy(@Param("id")Long id);


}
