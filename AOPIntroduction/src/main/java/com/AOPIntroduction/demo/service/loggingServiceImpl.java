package com.AOPIntroduction.demo.service;

import com.AOPIntroduction.demo.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class loggingServiceImpl implements StudentService{
public StudentServiceImpl studentServiceimpl;

    public loggingServiceImpl(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }

    @Override
    public void createStudent(Student student) {
loggingUtility.logStart("StudentServiceImpl","createStudent");
studentServiceimpl.createStudent(student);
        loggingUtility.logEnd("StudentServiceImpl","createStudent");
    }
}
