package com.baeldung.lss.security;

import com.baeldung.lss.persistence.UserRepository;
import com.baeldung.lss.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
public class LssUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(), true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
