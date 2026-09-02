package com.JPA.JPACascading.Controller;

import com.JPA.JPACascading.Entity.Department;
import com.JPA.JPACascading.Service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String>createdepartment(@RequestBody Department department){
        departmentService.create(department);
        return ResponseEntity.ok("DONE");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>removedepartment(@PathVariable long id){
      departmentService.remove(id);
        return ResponseEntity.ok("DONE");
    }
}
