package com.JPARelationship.JPA.Relationship.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
@OneToMany(mappedBy="department")
    private List<Student> student=new ArrayList<>();

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;

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
}
