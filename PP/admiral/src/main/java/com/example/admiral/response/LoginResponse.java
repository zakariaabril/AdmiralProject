package com.example.admiral.response;

import com.example.admiral.model.Employer;

public class LoginResponse {
    String message;
    Boolean status;

    Employer employer;


    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
    public LoginResponse(String message, Boolean status, Employer employer) {
        this.message = message;
        this.status = status;
        this.employer = employer;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
