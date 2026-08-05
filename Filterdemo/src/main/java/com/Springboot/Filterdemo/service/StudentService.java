package com.Springboot.Filterdemo.service;

import com.Springboot.Filterdemo.Entity.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String createStudent(StudentEntity student){
        System.out.println("student created");
        System.out.println(student.getName());
        System.out.println(student.getId());
        return null;
    }
}
