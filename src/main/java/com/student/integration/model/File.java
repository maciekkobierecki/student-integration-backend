package com.student.integration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class File {
    private Long id;
    private String name;
    private String description;
    private String url;
    private Long createUserId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date createDate;
    private Long rating;
    private Long ratingCount;
    private Boolean isMarkable;

    public static File fromDriveFile(com.google.api.services.drive.model.File driveFile, Long userId){
        File file = new File();
        file.setName(driveFile.getName());
        file.setRating(0L);
        file.setRatingCount(1L);
        file.setCreateUserId(userId);
        file.setCreateDate(new Date());
        file.setDescription("Opis dokumentu");
        file.setUrl(driveFile.getWebViewLink());
        return file;
    }
}
