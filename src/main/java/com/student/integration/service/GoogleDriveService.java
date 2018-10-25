package com.student.integration.service;

import com.google.api.services.drive.model.FileList;

import java.io.IOException;
import java.security.GeneralSecurityException;


public interface GoogleDriveService {
    public FileList getFiles() throws IOException, GeneralSecurityException;
}
