package com.spring.SpringSecuritydemo.Controller;

import com.spring.SpringSecuritydemo.Entity.Role;
import com.spring.SpringSecuritydemo.Service.AuthService;
import com.spring.SpringSecuritydemo.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String>ctrateRole(@RequestBody Role role){
        roleService.create(role);
        return ResponseEntity.ok("ROLE CREATED SUCCESFULLY....");
    }
}
