package com.rest.api.model.service;

import com.rest.api.exception.AuthenticationException;
import com.rest.api.exception.ErrorCode;
import com.rest.api.model.dao.User;
import com.rest.api.model.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AuthMapper authMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authMapper.findByEmail(username);

        if(user == null) {
            throw new AuthenticationException(ErrorCode.UsernameOrPasswordNotFoundException);
        }

        return user;
    }
}
