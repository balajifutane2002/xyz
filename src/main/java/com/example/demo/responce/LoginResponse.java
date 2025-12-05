package com.example.demo.responce;


public class LoginResponse {

    private String status;
    private String message;
    private Integer userId;
    private String name;
    private String email;
    private String token;

    public LoginResponse() {}

    public LoginResponse(String status, String message, Integer userId, String name, String email, String token) {
        this.status = status;
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
