package com.student.integration.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Long id;
    private String groupName;
    private Long createUserId;
    private Long semesterId;
    private Long recruitmentActionId;
}
