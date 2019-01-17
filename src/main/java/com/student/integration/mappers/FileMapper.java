package com.student.integration.mappers;

import com.student.integration.model.File;
import com.student.integration.web.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FileMapper {
    List<File> getFiles(@Param("subjectId") Long subjectId, @Param("userId") Long userId, @Param("criteria") String criteria, @Param("pagination") Pagination pagination);

    File getFile(@Param("id") Long id);

    void insertFile(@Param("file") File file);

    void addFileSubjectAssociation(@Param("subjectId") Long subjectId, @Param("fileId") Long fileId);

    void updateFile(@Param("file") File file);

    void deleteFile(@Param("id") Long id);

    void markFilePositive(@Param("id") Long id);

    void markFileNegative(@Param("id") Long id);

    void userMarkedFile(@Param("id") Long id, @Param("userId") Long userId);
}
