package com.student.integration.service.user.impl;

import com.student.integration.service.user.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean hasPermission(String token) {
        return true;
    }
}
