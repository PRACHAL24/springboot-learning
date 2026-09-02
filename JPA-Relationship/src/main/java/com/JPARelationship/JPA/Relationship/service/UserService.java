package com.JPARelationship.JPA.Relationship.service;

import com.JPARelationship.JPA.Relationship.model.User;
import com.JPARelationship.JPA.Relationship.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createuser(User user){
       return userRepository.save(user);
    }
}
