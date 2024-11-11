package com.example.mapped.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // You would typically inject your UserRepository here
    // private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here you would typically fetch the user from your database
        // User user = userRepository.findByUsername(username)
        //     .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // For now, we'll just throw an exception
        throw new UsernameNotFoundException("User not found: " + username);

        // Once you have your user entity, you would return a UserDetails object
        // return new org.springframework.security.core.userdetails.User(
        //     user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}