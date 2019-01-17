package com.student.integration.web.request;

import lombok.Data;

@Data
public class NewCommentRequest {
    private Long subjectId;
    private String content;
    private Boolean isAnonymous;
}
