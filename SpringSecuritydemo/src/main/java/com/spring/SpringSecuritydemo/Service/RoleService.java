package com.spring.SpringSecuritydemo.Service;

import com.spring.SpringSecuritydemo.Entity.Role;
import com.spring.SpringSecuritydemo.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void create(Role role){
         roleRepository.save(role);
    }
}
