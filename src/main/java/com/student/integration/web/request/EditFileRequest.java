package com.student.integration.web.request;

import lombok.Data;

@Data
public class EditFileRequest {
    private Long id;
    private String name;
    private String content;
}
