package com.student.integration.web.response;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class File {
    private final String id;
    private final String createDate;
    private final String name;
    private final String content;
    private final String url;
}
