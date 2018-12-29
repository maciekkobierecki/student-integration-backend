package com.student.integration.web.controller;

import com.student.integration.security.SiUserDetails;
import com.student.integration.service.login.LoginService;
import com.student.integration.web.request.LoginRequest;
import com.student.integration.web.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final LoginService loginService;

    @PostMapping("/api/auth/singin")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest req, @AuthenticationPrincipal SiUserDetails userDetails){
            String jwt = loginService.login(req.getFacebookAccessToken());
            return ResponseEntity.ok(new LoginResponse(jwt));
    }
}
