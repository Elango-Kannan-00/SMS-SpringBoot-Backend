package com.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PostMapping
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto request) {
        return service.addStudent(request);
    }

    // HTTP GET
    @GetMapping
    public List<StudentResponseDto> getAllStudent() {
        return service.getAllStudent();
    }

    // HTTP PUT
    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@RequestBody StudentRequestDto request, @PathVariable long id) {
        return service.updateStudent(request, id);
    }

    // HTTP DELETE BY ID
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable long id) {
        return service.deleteStudentById(id);
    }

    // HTTP DELETE ALL
    @DeleteMapping
    public String deleteAll() {
        return service.deleteAllStudent();
    }
}
