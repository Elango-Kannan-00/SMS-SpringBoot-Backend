package com.student_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_management.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    
}   
