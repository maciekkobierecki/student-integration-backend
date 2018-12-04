package com.student.integration.service.login.facebook.impl;

import com.student.integration.model.User;
import com.student.integration.service.login.facebook.FacebookDataService;
import com.student.integration.service.login.facebook.FacebookFieldId;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacebookDataServiceImpl implements FacebookDataService {

    @Override
    public Optional<String> fetchUserEmail(String fbAccessToken) {
        Facebook facebook = new FacebookTemplate(fbAccessToken);
        User user = facebook.fetchObject("me", User.class, FacebookFieldId.EMAIL.toString());
        return Optional.ofNullable(user.getEmail());
    }
}
