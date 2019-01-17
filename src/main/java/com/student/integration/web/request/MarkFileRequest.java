package com.student.integration.web.request;

import lombok.Data;

@Data
public class MarkFileRequest {
    private Long fileId;
    private Boolean isPositive;
}
