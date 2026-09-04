package com.JPA.JPACascading.Repository;

import com.JPA.JPACascading.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
