package com.student.integration.web.controller;

import com.student.integration.model.File;
import com.student.integration.model.User;
import com.student.integration.service.file.FileService;
import com.student.integration.web.request.EditFileRequest;
import com.student.integration.web.request.FileListRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @RequestMapping(value = "/files", method= RequestMethod.POST)
    public List<File> getFiles(@RequestBody FileListRequest request) throws Exception{
        Thread.sleep(2000L);
        return fileService.getFiles(request.getSubjectId(), request.getCriteria());
    }

    @PostMapping(value = "/file/{subjectId}/new")
    public void createDocument(@PathVariable Long subjectId)throws Exception{
        Thread.sleep(2000L);
        fileService.createDocument(subjectId, getUser());
    }

    @PostMapping(value = "file/edit")
    public void editFile(@RequestBody EditFileRequest request) throws Exception{
        Thread.sleep(2000L);
        fileService.editFile(request.getId(), request.getName(), request.getContent());
    }

    private User getUser(){
        return new User(1L, "maciekkobierecki@gmail.com", "maciekkobierecki");
    }
}
