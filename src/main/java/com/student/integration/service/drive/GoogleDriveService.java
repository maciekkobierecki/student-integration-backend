package com.student.integration.service.drive;

import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.IOException;
import java.security.GeneralSecurityException;


public interface GoogleDriveService {
    FileList getFiles() throws IOException, GeneralSecurityException;
    File getFileMetadata(String fileId) throws IOException;
    String uploadFile(java.io.File file) throws IOException;
    void deleteFile(String fileId) throws IOException;
    File createDocument(String filename) throws IOException;
}
