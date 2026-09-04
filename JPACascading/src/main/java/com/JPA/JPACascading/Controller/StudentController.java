package com.JPA.JPACascading.Controller;

import com.JPA.JPACascading.Entity.Department;
import com.JPA.JPACascading.Entity.Student;
import com.JPA.JPACascading.Service.DepartmentService;
import com.JPA.JPACascading.Service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    private DepartmentService departmentService;

    public StudentController(StudentService studentService,DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;

    }

    @PostMapping("/{id}")
    public ResponseEntity<String>craeteStudent(@RequestBody Student student, @PathVariable int id){
        Department department= departmentService.findById(id);
        student.setDepartment(department);
        studentService.create(student);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/new")
    public ResponseEntity<String>craeteStudent(@RequestBody Student student,@RequestParam String DepartmentName){
        Department department=new Department();
        department.setName(DepartmentName);
        departmentService.create(department);
        student.setDepartment(department);
        studentService.create(student);
        return ResponseEntity.ok("DONE");
    }


}
