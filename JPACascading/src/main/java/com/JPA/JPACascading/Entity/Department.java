package com.JPA.JPACascading.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
@OneToMany(mappedBy = "department",
        cascade =CascadeType.ALL)
private List<Student> student=new ArrayList<>();

    public Department(Integer id, String name, List<Student> student) {
        this.id = id;
        this.name = name;
        this.student = student != null ? student : new ArrayList<>();
    }
public Department(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
