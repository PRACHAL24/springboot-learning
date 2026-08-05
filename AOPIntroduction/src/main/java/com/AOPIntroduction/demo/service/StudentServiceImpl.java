package com.AOPIntroduction.demo.service;

import com.AOPIntroduction.demo.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Override
    public void createStudent(Student student) {
//      StudentRepository.save(student);
        System.out.println("Student created");
    }
}
