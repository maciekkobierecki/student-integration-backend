package com.student.integration.model;

import lombok.Data;

import java.util.Date;

@Data
public class SubjectComment {
    private Long id;
    private String content;
    private Date createDate;
    private String author;
}
