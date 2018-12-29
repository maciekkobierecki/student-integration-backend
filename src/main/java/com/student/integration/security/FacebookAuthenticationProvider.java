package com.student.integration.security;

import com.student.integration.service.login.facebook.FacebookDataService;
import com.student.integration.service.user.SiUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Slf4j
@Component
public class FacebookAuthenticationProvider implements AuthenticationProvider {
    private final FacebookDataService facebookDataService;
    private final SiUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String fbAccessToken = (String)authentication.getPrincipal();
        String email = facebookDataService.fetchUserEmail(fbAccessToken)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot fetch username by access token = "+fbAccessToken));
        SiUserDetails userDetails = userDetailsService.loadUserByEmail(email);
        if(userDetails == null){
            //TODO: add proper displayname
            userDetailsService.createUser(email, "testing name");
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
