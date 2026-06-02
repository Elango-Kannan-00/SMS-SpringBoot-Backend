package com.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_management.dto.StudentRequestDto;
import com.student_management.dto.StudentResponseDto;
import com.student_management.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // HTTP POST
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto request) {
        return service.addStudent(request);
    }

    // HTTP GET
    @GetMapping
    public List<StudentResponseDto> getStudent() {
        return service.getStudent();
    }
}
