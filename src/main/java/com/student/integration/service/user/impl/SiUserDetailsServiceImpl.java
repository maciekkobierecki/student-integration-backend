package com.student.integration.service.user.impl;

import com.student.integration.mappers.UserMapper;
import com.student.integration.model.User;
import com.student.integration.security.SiUserDetails;
import com.student.integration.service.user.SiUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiUserDetailsServiceImpl implements UserDetailsService, SiUserDetailsService {
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Not found user with email = "+username);
        }
        return SiUserDetails.create(user);
    }

    public SiUserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userMapper.getUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Not found user with email = "+email);
        }
        return SiUserDetails.create(user);
    }

    public SiUserDetails loadUserById(Long id){
        User user = userMapper.getUser(id);
        if(user == null){
            throw new UsernameNotFoundException("Not found user with id = "+id);
        }
        return SiUserDetails.create(user);
    }

    @Override
    public Long createUser(String email, String displayName) {
        User user = new User();
        user.setEmail(email);
        user.setDisplayName(displayName);
        userMapper.insertUser(user);
        return user.getId();
    }
}
