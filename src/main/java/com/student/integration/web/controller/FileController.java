package com.student.integration.web.controller;

import com.google.api.services.drive.model.FileList;
import com.student.integration.service.GoogleDriveService;
import com.student.integration.web.response.File;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final GoogleDriveService googleDriveService;

    @RequestMapping(value = "/files", method= RequestMethod.GET)
    public List<File> getFiles(){
        return getFileList();
    }

    public List<File> getFileList(){
        List<File> files = new ArrayList<>();
        File file = new File("15", "12 grudnia 2015","Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file1 = new File("16", "12 grudnia 2015","Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file2 = new File("17", "12 grudnia 2015","Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file3 = new File("18", "12 grudnia 2015","Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        File file4 = new File("19", "12 grudnia 2015","Bezpieczeństwo Usług w Sieci", "Przykładowy opis dokumentu znajdującego się w google documents", "https://docs.google.com/document/d/1vlN3jeECgTVRO0h5l9ZRl1k1hFDtEKypoYUKzo5FFeM/edit?usp=sharing");
        files.add(file);
        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);
        return files;
    }

    @GetMapping(value = "/drive")
    public FileList goToDrive(){
        try {
            return googleDriveService.getFiles();
        }catch(Exception e){
            return null;
        }
    }
}
