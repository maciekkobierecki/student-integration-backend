package com.student.integration.web.request;

import lombok.Data;

@Data
public class CreateGroupReq {
    private Long academyId;
    private Long degreeId;
    private String groupName;
    private Long semesterNo;
}
