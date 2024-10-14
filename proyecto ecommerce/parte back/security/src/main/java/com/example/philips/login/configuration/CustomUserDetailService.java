package com.example.philips.login.configuration;

import com.example.philips.login.entities.CredentialsEntity;
import com.example.philips.login.repositories.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Configuration
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CredentialsEntity credentials = credentialsRepository.findByUsername(username);
        return new User(credentials.getUsername(), credentials.getPassword(), AuthorityUtils.createAuthorityList(credentials.getRole().toString()));
    }
}
