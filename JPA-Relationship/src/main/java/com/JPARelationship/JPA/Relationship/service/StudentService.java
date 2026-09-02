package com.JPARelationship.JPA.Relationship.service;

import com.JPARelationship.JPA.Relationship.model.Student;
import com.JPARelationship.JPA.Relationship.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Transactional
    public Student createstudent(Student student){
        return studentRepository.save(student);
    }
}
