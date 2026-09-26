package com.spring.SpringSecuritydemo.Controller;

import com.spring.SpringSecuritydemo.DTO.UserRequestDTO;
import com.spring.SpringSecuritydemo.DTO.UserResponseDTO;
import com.spring.SpringSecuritydemo.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<String>sayhello(){
        return ResponseEntity.ok("HELLO WORLD...");
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO){
       UserResponseDTO userResponseDTO= authService.register(userRequestDTO);
       return ResponseEntity.ok(userResponseDTO);
    }


    @GetMapping("/Token")
    public CsrfToken createToken(CsrfToken csrfToken) {
        return csrfToken;
    }
}
