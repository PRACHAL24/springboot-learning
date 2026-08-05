package com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.controller;

import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO.StudentReqDTO;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO.StudentRespoDTO;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO.UpdateStudentRespoDTO;
import com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentRespoDTO>create(@RequestBody StudentReqDTO studentReqDTO){
        StudentRespoDTO studentrespo=studentService.create(studentReqDTO);
        return ResponseEntity.ok(studentrespo);
    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }

    @GetMapping
    public ResponseEntity<List<StudentRespoDTO>>getAll(){
        List<StudentRespoDTO> studentrespo= studentService.getAll();
        return ResponseEntity.ok(studentrespo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentRespoDTO>getbyid(@PathVariable Long id){
         StudentRespoDTO studentrespo =studentService.getbyid(id);
         return ResponseEntity.ok(studentrespo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentRespoDTO>update(@Valid @RequestBody UpdateStudentRespoDTO updatestudentReqDTO, @PathVariable Long id){
        UpdateStudentRespoDTO studentrespo=studentService.update(updatestudentReqDTO,id);
        return ResponseEntity.ok(studentrespo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentRespoDTO>delete(@PathVariable long id){
      studentService.delete(id);
      return ResponseEntity.noContent().build();
    }

}
