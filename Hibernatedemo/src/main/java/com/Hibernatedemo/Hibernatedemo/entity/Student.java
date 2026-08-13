package com.Hibernatedemo.Hibernatedemo.entity;

import com.Hibernatedemo.Hibernatedemo.StudentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_name")
    private String name;

//    private String email;
//    private String subject;
//
//    @Enumerated(EnumType.STRING)
//    private StudentStatus student_status;
//
//    private LocalDateTime createdat;
//
//    @Embedded
//private Address address;


    @ElementCollection
    @CollectionTable(name = "skills",
            joinColumns=@JoinColumn(name="id")
    )

    private Set<String> skills;

//    public Student(Integer id, String name, String email, String subject, StudentStatus student_status,
//                   LocalDateTime createdat, Address address, Set<String> skills) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.subject = subject;
//        this.student_status = student_status;
//        this.createdat = createdat;
//        this.address = address;
//        this.skills = skills;
//    }
           public Student(Integer id, String name, Set<String> skills) {
            this.id = id;
            this.name = name;
            this.skills = skills;
        }


//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public StudentStatus getStudent_status() {
//        return student_status;
//    }
//
//    public void setStudent_status(StudentStatus student_status) {
//        this.student_status = student_status;
//    }
//
//    public LocalDateTime getCreatedat() {
//        return createdat;
//    }
//
//    public void setCreatedat(LocalDateTime createdat) {
//        this.createdat = createdat;
//    }
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}


