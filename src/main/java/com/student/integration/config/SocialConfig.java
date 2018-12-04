package com.student.integration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
public class SocialConfig {
    @Bean
    @Autowired
    public ConnectionFactoryLocator connectionFactoryLocator(@Value("facebook.clientId")String facebookClientId, @Value("facebook.clientSecret")String facebookClientSecret) {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(facebookClientId, facebookClientSecret));
        return registry;
    }

}
