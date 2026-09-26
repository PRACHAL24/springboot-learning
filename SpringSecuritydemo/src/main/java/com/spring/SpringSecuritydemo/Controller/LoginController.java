package com.spring.SpringSecuritydemo.Controller;

import com.spring.SpringSecuritydemo.DTO.LoginRequestDTO;
import com.spring.SpringSecuritydemo.DTO.LoginResponseDTO;
import com.spring.SpringSecuritydemo.Entity.User;
import com.spring.SpringSecuritydemo.Service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;
    private ResourceLoader resourceLoader;

    public LoginController(ResourceLoader resourceLoader,JWTService jwtService) {
        this.resourceLoader = resourceLoader;
        this.jwtService=jwtService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){
        Authentication authenticationrequest= UsernamePasswordAuthenticationToken.unauthenticated(
               loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        Authentication authentication=authenticationManager.authenticate(authenticationrequest);
        String token = jwtService.generateToken(authentication);

        return new LoginResponseDTO("User login successfully",token);
    }
}
