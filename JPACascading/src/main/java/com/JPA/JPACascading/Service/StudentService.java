package com.JPA.JPACascading.Service;

import com.JPA.JPACascading.Entity.Student;
import com.JPA.JPACascading.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Transactional
    public void create(Student student){
        studentRepository.save(student);
    }

}
