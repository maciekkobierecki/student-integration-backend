package com.student.integration.model;

import lombok.Data;

import java.util.List;

@Data
public class GroupInfo {
    private Long id;
    private String name;
    private String academyName;
    private String degreeName;
    private Long semesterNo;
    private String groupEnterHash;
    private List<Subject> subjects;
}
