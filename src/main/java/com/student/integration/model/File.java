package com.student.integration.model;

import lombok.Data;

import java.sql.Date;

@Data
public class File {
    private Long id;
    private String name;
    private String content;
    private String url;
    private Long createUserId;
    private String createDate;
    private Long rating;
    private Long ratingCount;

    public static File fromDriveFile(com.google.api.services.drive.model.File driveFile, User user){
        File file = new File();
        file.setName(driveFile.getName());
        file.setRating(0L);
        file.setRatingCount(0L);
        file.setCreateUserId(user.getId());
        file.setContent("Opis dokumentu");
        file.setUrl(driveFile.getWebViewLink());
        return file;
    }
}
