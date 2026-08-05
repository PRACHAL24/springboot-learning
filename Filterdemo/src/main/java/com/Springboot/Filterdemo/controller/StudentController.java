package com.Springboot.Filterdemo.controller;

import com.Springboot.Filterdemo.Entity.StudentEntity;
import com.Springboot.Filterdemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    public StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody StudentEntity student){
         studentService.createStudent(student);
       return ResponseEntity.ok("DONE");

    }
}
