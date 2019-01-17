package com.student.integration.service.file;

import com.student.integration.model.File;
import com.student.integration.model.User;
import com.student.integration.security.SiUserDetails;
import com.student.integration.web.Pagination;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<File> getFiles(Long subjectId, Long userId, String criteria, Pagination pagination);
    void createDocument(Long subjectId, Long userId) throws IOException;
    void editFile(Long id, String filename, String description);
    void markFile(Long id, Boolean isPositiveGrade, SiUserDetails userDetails);
}
