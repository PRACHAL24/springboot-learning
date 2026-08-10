package com.Hibernatedemo.Hibernatedemo.controller;

import com.Hibernatedemo.Hibernatedemo.entity.Student;
import com.Hibernatedemo.Hibernatedemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created succesfully in database");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudent(@RequestParam int id){
       Student student= studentService.getStudent(id);
       if(student==null){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student>updateStudent(@RequestBody Student student,@RequestParam int id){
        Student student1=studentService.updateStudent(student,id);
        if(student1==null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@RequestParam int id){
        studentService.deleteStudent(id);
        return "Student deleted sucessfully.";
    }
}
