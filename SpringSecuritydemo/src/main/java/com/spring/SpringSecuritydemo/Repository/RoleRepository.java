package com.spring.SpringSecuritydemo.Repository;

import com.spring.SpringSecuritydemo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByrolename(String rolename);
}
