package com.student.integration.web.request;

import com.student.integration.web.Pagination;
import lombok.Data;



@Data
public class FileListRequest {
    private Long subjectId;
    private String criteria;
    private Pagination pagination;
}
