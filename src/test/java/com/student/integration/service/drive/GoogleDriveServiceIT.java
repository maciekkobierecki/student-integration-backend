package com.student.integration.service.drive;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.student.integration.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GoogleDriveServiceIT extends ApplicationTests {
    @Autowired
    private GoogleDriveService googleDriveService;
    @Test
    public void shouldUploadFileToDrive() throws IOException{
        //given
        String fileName = "testFile.txt";
        java.io.File file = new ClassPathResource(fileName).getFile();
        //when
        String id = googleDriveService.uploadFile(file);
        //then
        String resultName = googleDriveService.getFileMetadata(id).getName();
        assertEquals(fileName, resultName);
        googleDriveService.deleteFile(id);
    }

    @Test
    public void shouldDeleteSpecifiedFile() throws IOException{
        //given
        String fileName = "testFile.txt";
        java.io.File file = new ClassPathResource(fileName).getFile();
        String id = googleDriveService.uploadFile(file);
        int errorCode = 0;
        //when
        try {
            googleDriveService.deleteFile(id);
            googleDriveService.getFileMetadata(id);
        }catch(GoogleJsonResponseException e){
            errorCode = e.getStatusCode();
        }
        //then
        assertEquals(404, errorCode);
    }
}
