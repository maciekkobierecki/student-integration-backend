package com.student.integration.web.response;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class File {
    private final String id;
    private final String content;
}
