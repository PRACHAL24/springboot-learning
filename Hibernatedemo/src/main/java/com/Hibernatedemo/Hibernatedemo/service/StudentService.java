package com.Hibernatedemo.Hibernatedemo.service;

import com.Hibernatedemo.Hibernatedemo.entity.Student;
import com.Hibernatedemo.Hibernatedemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }
@Transactional
    public Student createStudent(Student student){
        return  studentRepository.save(student);

    }
@Transactional
    public Student getStudent(int id){
        return  studentRepository.get(id);

    }
@Transactional
    public String deleteStudent(int id){
         studentRepository.remove(id);
        return "Student deleted successfulyy..";
    }
    @Transactional
    public Student updateStudent(Student student,int id){
  Student student1= getStudent(id);
  student1.setName(student.getName());
//  student1.setEmail(student.getEmail());
//  student1.setSubject(student.getSubject());
  return student1;
    }
}
