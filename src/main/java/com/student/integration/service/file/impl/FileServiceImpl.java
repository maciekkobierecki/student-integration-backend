package com.student.integration.service.file.impl;

import com.student.integration.mappers.FileMapper;
import com.student.integration.model.File;
import com.student.integration.model.User;
import com.student.integration.service.drive.GoogleDriveService;
import com.student.integration.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileMapper fileMapper;
    private final GoogleDriveService driveService;

    @Override
    public List<File> getFiles(Long subjectId, String criteria) {
        List<File> files = fileMapper.getFiles(criteria);
        return files;
    }

    @Override
    public void createDocument(Long subjectId, User user) throws IOException {
        com.google.api.services.drive.model.File createdFile = driveService.createDocument("Nowy dokument");
        File file = File.fromDriveFile(createdFile, user);
        fileMapper.insertFile(file);
    }

    @Override
    public void editFile(Long id, String filename, String description) {
        fileMapper.updateFile(id, filename, description);
    }
}
