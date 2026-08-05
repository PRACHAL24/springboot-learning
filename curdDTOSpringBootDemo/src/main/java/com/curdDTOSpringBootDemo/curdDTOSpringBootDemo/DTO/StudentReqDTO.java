package com.curdDTOSpringBootDemo.curdDTOSpringBootDemo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class StudentReqDTO {
    @NotBlank(message = "NOT BE NULL")
    private String name;
    @NotBlank
    private int roll_no;
    @NotBlank
    private String subject;
    @Email(message="ENTER PROPER EMAIL")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
