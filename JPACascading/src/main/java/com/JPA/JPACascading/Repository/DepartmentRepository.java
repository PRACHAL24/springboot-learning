package com.JPA.JPACascading.Repository;

import com.JPA.JPACascading.Entity.Department;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Department department){
        entityManager.persist(department);
    }
    public Department findById(int id){
        return entityManager.find(Department.class,id);
    }

    public void remove(Department department){
         entityManager.remove(department);
    }
}
