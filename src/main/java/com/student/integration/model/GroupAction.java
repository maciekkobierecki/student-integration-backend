package com.student.integration.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class GroupAction {
    private Long id;
    private Long groupId;
    private Boolean isActive;
    private Date validFrom;
    private String actionHash;
}
