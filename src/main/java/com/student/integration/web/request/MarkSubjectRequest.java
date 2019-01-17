package com.student.integration.web.request;

import com.student.integration.model.SubjectDetails;
import lombok.Data;

@Data
public class MarkSubjectRequest {
    private SubjectDetails subjectDetails;
    private Boolean isPositive;
}
