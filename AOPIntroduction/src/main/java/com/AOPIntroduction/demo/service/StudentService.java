package com.AOPIntroduction.demo.service;

import com.AOPIntroduction.demo.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public void createStudent(Student student);
}
