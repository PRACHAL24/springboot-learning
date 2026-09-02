package com.JPARelationship.JPA.Relationship.repository;

import com.JPARelationship.JPA.Relationship.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @PersistenceContext
    public EntityManager entityManager;

    public User save(User user){
        entityManager.persist(user);
        return user;
    }
}
