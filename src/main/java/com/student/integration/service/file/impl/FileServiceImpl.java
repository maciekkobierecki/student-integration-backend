package com.student.integration.service.file.impl;

import com.student.integration.mappers.FileMapper;
import com.student.integration.model.File;
import com.student.integration.model.User;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.drive.GoogleDriveService;
import com.student.integration.service.file.FileService;
import com.student.integration.web.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final FileMapper fileMapper;
    private final GoogleDriveService driveService;


    @Override
    public List<File> getFiles(Long subjectId, Long userId, String criteria, Pagination pagination) {
        return fileMapper.getFiles(subjectId, userId, criteria, pagination);
    }

    @Override
    public void createDocument(Long subjectId, Long userId) throws IOException {
        com.google.api.services.drive.model.File createdFile = driveService.createDocument("Nowy dokument");
        File file = File.fromDriveFile(createdFile, userId);
        saveFile(subjectId, file);
    }

    private void saveFile(Long subjectId, File file) {
        if (file.getId() == null) {
            fileMapper.insertFile(file);
            fileMapper.addFileSubjectAssociation(subjectId, file.getId());
        }else{
            fileMapper.updateFile(file);
        }
    }

    @Override
    public void editFile(Long id, String filename, String description) {
        File file = fileMapper.getFile(id);
        file.setName(filename);
        file.setDescription(description);
        fileMapper.updateFile(file);
    }

    @Override
    @Transactional
    public void markFile(Long id, Boolean isPositiveGrade, SiUserDetails userDetails) {
        if(isPositiveGrade){
            fileMapper.markFilePositive(id);
        }else{
            fileMapper.markFileNegative(id);
        }
        fileMapper.userMarkedFile(id, userDetails.getId());
    }
}
