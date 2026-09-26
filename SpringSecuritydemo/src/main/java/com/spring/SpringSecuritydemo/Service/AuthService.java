package com.spring.SpringSecuritydemo.Service;

import com.spring.SpringSecuritydemo.DTO.UserRequestDTO;
import com.spring.SpringSecuritydemo.DTO.UserResponseDTO;
import com.spring.SpringSecuritydemo.Entity.Role;
import com.spring.SpringSecuritydemo.Entity.User;
import com.spring.SpringSecuritydemo.Repository.RoleRepository;
import com.spring.SpringSecuritydemo.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
private UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public AuthService(UserRepository userRepository,RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository=roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public UserResponseDTO register(UserRequestDTO userRequestDTO){
      User user=new User();
      user.setUsername(userRequestDTO.getUsername());
      String encodePassword= passwordEncoder.encode(userRequestDTO.getPassword());
      user.setPassword(encodePassword);
        Role role=roleRepository.findByrolename("Role_User").get();
        user.getRoles().add(role);
      userRepository.save(user);
      UserResponseDTO userResponseDTO=new UserResponseDTO();
      userResponseDTO.setUsername(userRequestDTO.getUsername());
      userResponseDTO.setMessage("User created successfully........");
      return userResponseDTO;
    }

}
