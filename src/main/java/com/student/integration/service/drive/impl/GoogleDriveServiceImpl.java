package com.student.integration.service.drive.impl;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.Permission;
import com.student.integration.google.drive.FileType;
import com.student.integration.service.drive.GoogleDriveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Set;

@Slf4j
@Service
@Configuration
public class GoogleDriveServiceImpl implements GoogleDriveService {
    private final String applicationName;
    private final String credentialsFilePath;
    private final String tokensDirectoryPath;

    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();


    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final Set<String> SCOPES = DriveScopes.all();

    private final Drive service;

    @Autowired
    public GoogleDriveServiceImpl(
            @Value("${applicationName}") String applicationName,
            @Value("${drive.tokensDirectoryPath}") String tokensDirectoryPath,
            @Value("${drive.credentialsFilePath}") String credentialsFilePath,
            @Value("${drive.enabled}")Boolean driveEnabled) throws GeneralSecurityException, IOException {
        this.applicationName = applicationName;
        this.tokensDirectoryPath = tokensDirectoryPath;
        this.credentialsFilePath = credentialsFilePath;

        // Build a new authorized API client service.
        if(driveEnabled) {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                    .setApplicationName(applicationName)
                    .build();
        }else{
            service = null;
        }
    }

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GoogleDriveServiceImpl.class.getResourceAsStream(credentialsFilePath);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(tokensDirectoryPath)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receier = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receier).authorize("user");
    }

    @Override
    public File createDocument(String filename) throws IOException{
        File fileMetadata = new File();
        fileMetadata.setName(filename);
        fileMetadata.setMimeType("application/vnd.google-apps.document");
        File createdFile = service.files().create(fileMetadata)
                .setFields("id, name, webViewLink")
                .execute();
        Permission permission = new Permission();
        permission.set("role", "reader");
        permission.set("type", "anyone");
        service.permissions().create(createdFile.getId(), permission).execute();
        return createdFile;
    }

    @Override
    public FileList getFiles() throws IOException, GeneralSecurityException{
        return service.files().list()
                .execute();
    }

    @Override
    public String uploadFile(java.io.File file) throws IOException{
        File fileMetadata = new File();
        fileMetadata.setName(file.getName());
        //TODO: google returns bad mime type exception
        FileContent mediaContent = new FileContent(FileType.GOOGLE_DOCS.toString(), file);
        fileMetadata = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        return fileMetadata.getId();
    }

    @Override
    public File getFileMetadata(String fileId) throws IOException {
        return service.files().get(fileId).execute();
    }

    @Override
    public void deleteFile(String fileId) throws IOException {
        service.files().delete(fileId).execute();
    }
}