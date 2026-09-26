package com.spring.SpringSecuritydemo.Repository;

import com.spring.SpringSecuritydemo.Entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
@EntityGraph(attributePaths = "roles")
    Optional<User> findByusername(String username);
}
