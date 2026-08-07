package com.AOPIntroduction.demo.service;

import com.AOPIntroduction.demo.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createstudent(Student student) {
        System.out.println("student craeted..");
//        throw new RuntimeException("something went wrong");
return student;
    }
}
