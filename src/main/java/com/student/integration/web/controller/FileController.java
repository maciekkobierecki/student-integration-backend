package com.student.integration.web.controller;

import com.google.api.services.drive.model.FileList;
import com.student.integration.service.drive.GoogleDriveService;
import com.student.integration.web.request.FileListRequest;
import com.student.integration.web.response.File;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final GoogleDriveService googleDriveService;

    @RequestMapping(value = "/files", method= RequestMethod.POST)
    public List<File> getFiles(@RequestBody FileListRequest request) throws Exception{
        Thread.sleep(2000L);
        return getFileList(1L);
    }

    @PostMapping(value = "/files/{subjectId}")
    public void createDocument(@PathVariable Long subjectId)throws Exception{
        Thread.sleep(2000L);
    }



    public List<File> getFileList(Long subjectId){
        List<File> files = new ArrayList<>();
        File file = new File("15", "12 grudnia 2015", "Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file1 = new File("16", "12 grudnia 2015", "Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file2 = new File("17", "12 grudnia 2015", "Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file3 = new File("18", "12 grudnia 2015", "Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file4 = new File("19", "12 grudnia 2015", "Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        if(subjectId==1) {
            files.add(file);
            files.add(file1);
            files.add(file2);
            files.add(file3);
            files.add(file4);
        }else{
            files.add(file);
            files.add(file1);
        }
        return files;
    }

    @GetMapping(value = "/drive")
    public FileList goToDrive() throws InterruptedException{
        Thread.sleep(2000L);
        try {
            return googleDriveService.getFiles();
        }catch(Exception e){
            return null;
        }
    }
}
