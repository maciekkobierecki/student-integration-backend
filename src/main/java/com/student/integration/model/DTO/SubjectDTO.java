package com.student.integration.model.DTO;

import lombok.Data;

@Data
public class SubjectDTO {
    private Long id;
    private String subjectName;
    private String displayName;
    private String displayNameShort;
    private Long academyId;
}
