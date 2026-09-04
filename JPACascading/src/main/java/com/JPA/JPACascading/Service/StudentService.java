package com.JPA.JPACascading.Service;

import com.JPA.JPACascading.Entity.Student;
import com.JPA.JPACascading.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
