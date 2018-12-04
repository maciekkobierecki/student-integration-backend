package com.student.integration.web.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginResponse {
    private final String jwt;
}
