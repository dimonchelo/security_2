package com.example.demo.configs;


import com.example.demo.security.UserDetailss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
@Autowired
    public AuthProviderImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        UserDetails userDetailss = userDetailsService.loadUserByUsername(name);
        String password = authentication.getCredentials().toString();
        if (!password.equals(userDetailss.getPassword()))
            throw new BadCredentialsException("password -");
        return new UsernamePasswordAuthenticationToken(userDetailss, password, Collections.emptyList() );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
