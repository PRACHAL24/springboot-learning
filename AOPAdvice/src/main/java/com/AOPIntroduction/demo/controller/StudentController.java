package com.AOPIntroduction.demo.controller;

import com.AOPIntroduction.demo.Student;
import com.AOPIntroduction.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<Student>createstudent(@RequestBody Student student){
        Student s=studentService.createstudent(student);
        return ResponseEntity.ok(s);
    }
}
