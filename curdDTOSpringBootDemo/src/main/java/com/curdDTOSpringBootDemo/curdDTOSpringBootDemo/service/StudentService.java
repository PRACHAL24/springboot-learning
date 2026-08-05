package com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.service;

import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO.StudentReqDTO;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO.StudentRespoDTO;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO.UpdateStudentRespoDTO;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.GlobalExceptionHandler.NotFoundException;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.entity.Student;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentRespoDTO create(StudentReqDTO studentreq){
       Student student=mapToEntity(studentreq);
       Student savestudent=studentRepository.save(student);
       return mapToDTO(savestudent);
    }

    public List<StudentRespoDTO> getAll() {
        List<Student> getstudent = studentRepository.findAll();
       return getstudent.stream()
               .map(this::mapToDTO)
               .toList();
    }
    public StudentRespoDTO getbyid(Long id) {
        Student studentrespo=studentRepository
                             .findById(id)
                             .orElseThrow(()->new NotFoundException("ID IS NOT FOUND IN DATABASE"));

        return mapToDTO(studentrespo);
    }

    public UpdateStudentRespoDTO update(UpdateStudentRespoDTO updateStudentReqDto, Long id){
        Student studentexist= studentRepository
                .findById(id)
                .orElseThrow(()->new NotFoundException("ID IS NOT FOUND IN DATABASE"));


        studentexist.setSubject(updateStudentReqDto.getSubject());
         studentRepository.save(studentexist);
         return mapToupdateDTO(studentexist);
    }

    public void delete(Long id){
    Student student=studentRepository.findById(id).orElseThrow();
       studentRepository.delete(student);
    }

    private Student mapToEntity(StudentReqDTO studentReqDTO){
        Student student=new Student();
        student.setName(studentReqDTO.getName());
        student.setRoll_no(studentReqDTO.getRoll_no());
        student.setSubject(studentReqDTO.getSubject());
        student.setEmail(studentReqDTO.getEmail());
       student.setCreated_at(LocalDateTime.now());
       student.setUpdated_at(LocalDateTime.now());
        return student;
    }

    private StudentRespoDTO mapToDTO(Student student){
       StudentRespoDTO studentRespoDTO=new StudentRespoDTO();
       studentRespoDTO.setEmail(student.getEmail());
       studentRespoDTO.setName(student.getName());
       studentRespoDTO.setSubject(student.getSubject());
       studentRespoDTO.setCreated_at(LocalDateTime.now());
       studentRespoDTO.setUpdated_at(LocalDateTime.now());
       studentRespoDTO.setRoll_no(student.getRoll_no());
       studentRespoDTO.setId(student.getId());
       studentRespoDTO.setMsg("CREATED SUCSESSFULLY......");
       return studentRespoDTO;
    }


    private UpdateStudentRespoDTO mapToupdateDTO(Student student){
        UpdateStudentRespoDTO updateStudentRespoDTO=new UpdateStudentRespoDTO();
        updateStudentRespoDTO.setEmail(student.getEmail());
        updateStudentRespoDTO.setId(student.getId());
        updateStudentRespoDTO.setName(student.getName());
        updateStudentRespoDTO.setSubject(student.getSubject());
        updateStudentRespoDTO.setCreated_at(LocalDateTime.now());
        updateStudentRespoDTO.setUpdated_at(LocalDateTime.now());
        updateStudentRespoDTO.setMsg("UPDATED SUCESSFULLY.....");
            return updateStudentRespoDTO;
    }
}
