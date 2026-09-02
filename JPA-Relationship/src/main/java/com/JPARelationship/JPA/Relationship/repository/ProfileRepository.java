package com.JPARelationship.JPA.Relationship.repository;

import com.JPARelationship.JPA.Relationship.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Profile save(Profile profile){
        entityManager.persist(profile);
        return profile;
    }

    public Profile find(int profile_id){
        return entityManager.find(Profile.class,profile_id);
    }
}
