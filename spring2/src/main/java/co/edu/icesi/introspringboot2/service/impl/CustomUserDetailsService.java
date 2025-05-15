package co.edu.icesi.introspringboot2.service.impl;

import co.edu.icesi.introspringboot2.entity.User;
import co.edu.icesi.introspringboot2.security.CustomUserDetail;
import co.edu.icesi.introspringboot2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);
        //Cómo hacer esto: User -> UserDetail
        return new CustomUserDetail(user);
    }
}