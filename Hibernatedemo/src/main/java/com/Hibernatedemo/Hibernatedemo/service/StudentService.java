package com.Hibernatedemo.Hibernatedemo.service;

import com.Hibernatedemo.Hibernatedemo.entity.Student;
import com.Hibernatedemo.Hibernatedemo.repository.StudentRepository;
import org.springframework.stereotype.Service;



@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
      Student student1= studentRepository.save(student);
      return student1;
    }

    public Student getStudent(int id){
       Student student= studentRepository.get(id);
       return student;
    }

    public String deleteStudent(int id){
         studentRepository.remove(id);
        return "Student deleted successfulyy..";
    }
    public Student updateStudent(Student student,int id){
  Student student1= getStudent(id);
  student1.setName(student.getName());
  student1.setEmail(student.getEmail());
  student1.setSubject(student.getSubject());
  return student1;
    }
}
