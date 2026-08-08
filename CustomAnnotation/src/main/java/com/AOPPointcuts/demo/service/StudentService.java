package com.AOPPointcuts.demo.service;

import com.AOPPointcuts.demo.Student;
import com.AOPPointcuts.demo.annotation.Measuretime;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String getStudentData() {
        return "Student data from service";
    }
@Measuretime
    public Student saveStudent(Student student) {
        try {
            Thread.sleep(4000);
            System.out.println("Student created....");
        } catch (InterruptedException e) {
        }
    return student;
    }

    public String deleteStudent() {
        return "Student deleted";
    }
}
