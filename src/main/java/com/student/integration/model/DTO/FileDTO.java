package com.student.integration.model.DTO;

import lombok.Data;

@Data
public class FileDTO {
    private Long id;
    private Long createUserId;
    private Long rating;
    private Long ratingCount;
}
