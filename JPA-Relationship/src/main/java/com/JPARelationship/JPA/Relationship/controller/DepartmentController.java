package com.JPARelationship.JPA.Relationship.controller;

import com.JPARelationship.JPA.Relationship.model.Department;
import com.JPARelationship.JPA.Relationship.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public ResponseEntity<String>createDepartment(@RequestBody Department department){
        departmentService.createdepartment(department);
        return ResponseEntity.ok("DONE");
    }
}
