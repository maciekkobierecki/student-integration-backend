package com.student.integration.model;

import lombok.Data;

@Data
public class File {
    private Long id;
    private Long createUserId;
    private Long rating;
    private Long ratingCount;
}
