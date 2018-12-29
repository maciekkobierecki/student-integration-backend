package com.student.integration.model;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private Long id;
    private String name;
    private String academyName;
    private String degreeName;
    private Long semesterNo;
    private String url;
    private List<Subject> subjects;
}
