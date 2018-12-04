package com.student.integration.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String displayName;
    private String firstName;
    private String lastName;
}
