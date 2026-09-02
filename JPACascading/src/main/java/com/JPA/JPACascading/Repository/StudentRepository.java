package com.JPA.JPACascading.Repository;

import com.JPA.JPACascading.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }
}
