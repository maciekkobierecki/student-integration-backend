package com.student.integration.web.controller;

import com.student.integration.model.Subject;
import com.student.integration.model.SubjectComment;
import com.student.integration.model.SubjectDetails;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.subject.SubjectService;
import com.student.integration.web.Pagination;
import com.student.integration.web.request.MarkSubjectRequest;
import com.student.integration.web.request.NewCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UniversitySubjectController {
    private final SubjectService subjectService;

    //TODO: Use in Group creation page to select extra Subjcets
    @GetMapping("/api/academy/{academyId}/subjects")
    public List<Subject> getSubjects(@PathVariable("academyId") Long academyId) {
        return subjectService.getAllSubjectsOfAcademy(academyId);
    }

    @PostMapping("/api/subjects")
    public List<Subject> getAllSubjects(@RequestBody Pagination pagination) {
        return subjectService.getSubjects(pagination);
    }

    @GetMapping("/api/degrees/{degreeId}/subjects")
    public List<Subject> getSubjectsByDegree(@PathVariable("degreeId") Long degreeId) {
        return subjectService.getSubjectsBoundToDegree(degreeId);
    }

    @GetMapping("/api/subjects/{id}/details")
    public SubjectDetails getSubjectDetails(@PathVariable Long id, @AuthenticationPrincipal SiUserDetails userDetails) {
        return subjectService.getSubjectDetails(id, userDetails);
    }

    @GetMapping("api/subjects/{id}/comments")
    public List<SubjectComment> getComments(@PathVariable Long id) {
        return subjectService.getSubjectComments(id);
    }

    @PostMapping("api/subjects/comments/new")
    public void addComment(@RequestBody NewCommentRequest newCommentRequest, @AuthenticationPrincipal SiUserDetails siUserDetails) {
        subjectService.addNewComment(newCommentRequest.getSubjectId(), newCommentRequest.getContent(), newCommentRequest.getIsAnonymous(), siUserDetails);
    }

    @PostMapping(value = "/api/subjects/mark")
    public SubjectDetails markFile(@RequestBody MarkSubjectRequest markSubjectRequest, @AuthenticationPrincipal SiUserDetails userDetails) {
        subjectService.markSubject(markSubjectRequest.getSubjectDetails(), markSubjectRequest.getIsPositive(), userDetails);
        return markSubjectRequest.getSubjectDetails();
    }
}
