package com.example.demo.Workers.service;

public class QualificationNotFoundException extends RuntimeException {
    public QualificationNotFoundException(Long id) {
        super(String.format("Qualification with id [%s] is not found", id));
    }
}