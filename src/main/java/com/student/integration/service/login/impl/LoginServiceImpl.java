package com.student.integration.service.login.impl;

import com.student.integration.security.JwtTokenProvider;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.login.LoginService;
import com.student.integration.service.login.facebook.FacebookDataService;
import com.student.integration.service.user.SiUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final FacebookDataService facebookDataService;
    private final SiUserDetailsService userDetailsService;

    @Override
    public String login(String facebookAccessToken) {
        String email = facebookDataService.fetchUserEmail(facebookAccessToken)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot fetch username by access token = "+facebookAccessToken));
        SiUserDetails userDetails = userDetailsService.loadUserByEmail(email);
        Long userId = null;

        if(userDetails == null){
            userId = userDetailsService.createUser(email);
        }else{
            userId = userDetails.getId();
        }
        return tokenProvider.generateToken(userId);
    }

    private Authentication authenticate(String email) {
        Authentication authentication;
        authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        null
                ));
        return authentication;
    }
}
