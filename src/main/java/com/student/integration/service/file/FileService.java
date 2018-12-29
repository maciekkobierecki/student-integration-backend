package com.student.integration.service.file;

import com.student.integration.model.File;
import com.student.integration.model.User;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<File> getFiles(Long subjectId, String criteria);
    void createDocument(Long subjectId, Long userId) throws IOException;
    void editFile(Long id, String filename, String description);
}
