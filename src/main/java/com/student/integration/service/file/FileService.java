package com.student.integration.service.file;

import com.student.integration.model.File;
import com.student.integration.model.User;

import java.io.IOException;
import java.util.List;

public interface FileService {
    public List<File> getFiles(Long subjectId, String criteria);
    public void createDocument(Long subjectId, User user) throws IOException;
    public void editFile(Long id, String filename, String description);
}
