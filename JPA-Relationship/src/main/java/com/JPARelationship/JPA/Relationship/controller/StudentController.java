package com.JPARelationship.JPA.Relationship.controller;

import com.JPARelationship.JPA.Relationship.model.Department;
import com.JPARelationship.JPA.Relationship.model.Student;
import com.JPARelationship.JPA.Relationship.service.DepartmentService;
import com.JPARelationship.JPA.Relationship.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    private DepartmentService departmentService;

    public StudentController(StudentService studentService,DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService=departmentService;
    }
@PostMapping
    public ResponseEntity<String>createStudent(@RequestBody Student student, @RequestParam int id){
        Department department= departmentService.findbyid(id);
        student.setDepartment(department);
        studentService.createstudent(student);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/new")
    public ResponseEntity<String>createStudent(@RequestBody Student student,@RequestParam String departmentName){
      Department department1=new Department();
      department1.setName(departmentName);
        departmentService.createdepartment(department1);
      student.setDepartment(department1);
      studentService.createstudent(student);
        return ResponseEntity.ok("DONE");
    }
}
