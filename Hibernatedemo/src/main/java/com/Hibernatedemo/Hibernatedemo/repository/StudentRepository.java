package com.Hibernatedemo.Hibernatedemo.repository;

import com.Hibernatedemo.Hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Transient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  Student save(Student student){
        entityManager.persist(student);
        return student;
    }


    public Student get(int id){
       Student student= entityManager.find(Student.class,id);
       return student;
    }

    public void remove(int id){
        Student student= entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

}
