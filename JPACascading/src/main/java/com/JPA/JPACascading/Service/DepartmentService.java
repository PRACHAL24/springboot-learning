package com.JPA.JPACascading.Service;

import com.JPA.JPACascading.Entity.Department;
import com.JPA.JPACascading.Entity.Student;
import com.JPA.JPACascading.Repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Transactional
    public Department create(Department department){

        Student s1=new Student();
        s1.setName("SANIKA");
        s1.setDepartment(department);

        Student s2=new Student();
        s2.setName("SAHIL");
        s2.setDepartment(department);

        Student s3=new Student();
        s3.setName("SUJAL");
        s3.setDepartment(department);

        Student s4=new Student();
        s4.setName("NIKITA");
        s4.setDepartment(department);

        Student s5=new Student();
        s5.setName("PRACHI");
        s5.setDepartment(department);

        department.getStudent().addAll(List.of(s1,s2,s3,s4,s5));
        departmentRepository.save(department);
        return department;
    }
    @Transactional
    public Department remove(long id){
       Department department= departmentRepository.findById((int) id);
       departmentRepository.remove(department);
       return department;
    }

    @Transactional
    public Department findById(int id){
       return departmentRepository.findById(id);
    }

}
