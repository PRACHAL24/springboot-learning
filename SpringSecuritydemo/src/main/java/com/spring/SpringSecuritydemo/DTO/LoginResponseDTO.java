package com.spring.SpringSecuritydemo.DTO;

import jakarta.persistence.Entity;


public class LoginResponseDTO {
    private String msg;
    private String token;

    public LoginResponseDTO(String msg, String token) {
        this.msg = msg;
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
