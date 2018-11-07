package com.student.integration.mappers;

import com.student.integration.model.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {
    List<File> getFiles();

    File getFile(@Param("id") Long id);

    void insertFile(@Param("file")File file);

    void updateFile(@Param("file")File file);

    void deleteFile(@Param("id")Long id);
}
