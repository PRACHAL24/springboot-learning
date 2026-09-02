package com.JPARelationship.JPA.Relationship.repository;

import com.JPARelationship.JPA.Relationship.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Department save(Department department){
        entityManager.persist(department);
        return department;
    }

    public Department find(int id){
       return entityManager.find(Department.class,id);
    }
}
