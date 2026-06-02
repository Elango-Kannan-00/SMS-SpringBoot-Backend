package com.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student_management.dto.StudentResponseDto;
import com.student_management.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // HTTP POST
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto request) {
        return service.addStudent(request);
    }
}
