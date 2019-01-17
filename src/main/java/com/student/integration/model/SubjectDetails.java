package com.student.integration.model;

import lombok.Data;

@Data
public class SubjectDetails {
    private Long id;
    private String name;
    private String shortName;
    private String academyName;
    private int rating;
    private int ratingCount;
    private int filesCount;
    private int commentsCount;
    private Boolean isMarkable;
}
