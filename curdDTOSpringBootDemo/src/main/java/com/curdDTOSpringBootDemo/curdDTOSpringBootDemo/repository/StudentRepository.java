package com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.repository;

import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
