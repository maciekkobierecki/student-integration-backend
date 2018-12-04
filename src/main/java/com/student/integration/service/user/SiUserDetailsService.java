package com.student.integration.service.user;

import com.student.integration.security.SiUserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface SiUserDetailsService {
    public SiUserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
    public SiUserDetails loadUserById(Long id);
    public Long createUser(String email);
}
