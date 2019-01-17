package com.student.integration.web.controller;

import com.student.integration.model.File;
import com.student.integration.model.User;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.file.FileService;
import com.student.integration.web.request.EditFileRequest;
import com.student.integration.web.request.FileListRequest;
import com.student.integration.web.request.MarkFileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @RequestMapping(value = "/api/files", method = RequestMethod.POST)
    public List<File> getFiles(@RequestBody FileListRequest request, @AuthenticationPrincipal SiUserDetails userDetails) {
        return fileService.getFiles(request.getSubjectId(), userDetails.getId(), request.getCriteria(), request.getPagination());
    }

    @PostMapping(value = "/api/files/{subjectId}/new")
    public void createDocument(@PathVariable Long subjectId, @AuthenticationPrincipal SiUserDetails userDetails) throws IOException {
        fileService.createDocument(subjectId, userDetails.getId());
    }

    @PostMapping(value = "/api/file/edit")
    public void editFile(@RequestBody EditFileRequest request, @AuthenticationPrincipal SiUserDetails userDetails) {
        fileService.editFile(request.getId(), request.getName(), request.getContent());
    }

    @PostMapping(value = "/api/files/mark")
    public void markFile(@RequestBody MarkFileRequest markFileRequest, @AuthenticationPrincipal SiUserDetails userDetails) {
        fileService.markFile(markFileRequest.getFileId(), markFileRequest.getIsPositive(), userDetails);
    }
}
