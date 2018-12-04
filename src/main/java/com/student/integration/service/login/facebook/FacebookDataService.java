package com.student.integration.service.login.facebook;

import java.util.Optional;

public interface FacebookDataService {
    public Optional<String> fetchUserEmail(String fbAccessToken);
}
