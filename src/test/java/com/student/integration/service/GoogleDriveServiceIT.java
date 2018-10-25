package com.student.integration.service;

import com.google.api.services.drive.model.FileList;
import com.student.integration.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.Assert.assertEquals;

public class GoogleDriveServiceIT extends ApplicationTests {
    @Autowired
    private GoogleDriveService googleDriveService;

    @Test
    public void testDriveServiceFetchFiles(){
        //given

        //when
        FileList result = null;
        try {
            result = googleDriveService.getFiles();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        //then
        assertEquals(result.getFiles().get(0).getName(), "test");
    }

    @Test
    public void shouldUploadFileToDrive() throws IOException{
        //given
        String fileName = "testFile.txt";
        File file = new ClassPathResource(fileName).getFile();
        //when
        String id = googleDriveService.uploadFile(file);
        //then
        String resultName = googleDriveService.getFileMetadata(id).getName();
        assertEquals(fileName, resultName);
    }
}
