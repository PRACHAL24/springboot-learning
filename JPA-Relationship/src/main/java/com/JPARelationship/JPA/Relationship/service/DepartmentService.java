package com.JPARelationship.JPA.Relationship.service;

import com.JPARelationship.JPA.Relationship.model.Department;
import com.JPARelationship.JPA.Relationship.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Transactional
    public Department createdepartment(Department department){
       return departmentRepository.save(department);
    }

    @Transactional
    public Department findbyid(int id){
        return departmentRepository.find(id);
    }
}
