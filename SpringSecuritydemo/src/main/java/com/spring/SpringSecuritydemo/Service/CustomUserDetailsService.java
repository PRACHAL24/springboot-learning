package com.spring.SpringSecuritydemo.Service;

import com.spring.SpringSecuritydemo.Entity.CustomUserDetails;
import com.spring.SpringSecuritydemo.Entity.User;
import com.spring.SpringSecuritydemo.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepository.findByusername(username)
               .orElseThrow(()->new RuntimeException("USER IS NOT FOUND...."));
       return new CustomUserDetails(user);
    }
}
