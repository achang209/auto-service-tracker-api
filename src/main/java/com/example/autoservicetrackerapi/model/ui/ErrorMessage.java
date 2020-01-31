package com.example.autoservicetrackerapi.model.ui;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ErrorMessage {

    private Date timestamp;
    private HttpStatus status;
    private List<String> errors;

    public ErrorMessage() {
    }

    public ErrorMessage(Date timestamp, HttpStatus status, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.errors = errors;
    }

    public ErrorMessage(Date timestamp, HttpStatus status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setError(String error) {
        this.errors = Arrays.asList(error);
    }
}
