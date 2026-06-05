package com.student_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_management.dto.StudentRequestDto;
import com.student_management.dto.StudentResponseDto;
import com.student_management.entity.Student;
import com.student_management.exception.StudentException;
import com.student_management.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Add student method.
    public StudentResponseDto addStudent(StudentRequestDto request) {

        Student student = new Student();

        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setDepartment(request.getDepartment());
        student.setMobileNo(request.getMobileNo());
        student.setAge(request.getAge());
        student.setCgpa(request.getCgpa());

        Student savedStudent = repository.save(student);

        StudentResponseDto response = new StudentResponseDto();

        response.setId(savedStudent.getId());
        response.setName(savedStudent.getName());
        response.setDepartment(savedStudent.getDepartment());
        response.setCgpa(savedStudent.getCgpa());

        return response;
    }

    // Get all student method.
    public List<StudentResponseDto> getAllStudent() {

        // List of student objects for iteration.
        List<Student> students = repository.findAll();

        // List of DTOs for returning response.
        List<StudentResponseDto> response = new ArrayList<>();

        for (Student student : students) {

            // Individual DTO for each student.
            StudentResponseDto dto = new StudentResponseDto();

            dto.setId(student.getId());
            dto.setName(student.getName());
            dto.setDepartment(student.getDepartment());
            dto.setCgpa(student.getCgpa());

            response.add(dto);

        }
        return response;
    }

    // Update student by Id.
    public StudentResponseDto updateStudent(StudentRequestDto request, long id) {
        Student student = repository.findById(id)
                            .orElseThrow(() -> new StudentException("No student found with id: " + id));
        
        student.setName(request.getName());
        student.setDepartment(request.getDepartment());
        student.setCgpa(request.getCgpa());
        student.setEmail(request.getEmail());
        student.setMobileNo(request.getMobileNo());
        student.setAge(request.getAge());

        Student updatedStudent = repository.save(student);

        StudentResponseDto response = new StudentResponseDto();

        response.setId(updatedStudent.getId());
        response.setName(updatedStudent.getName());
        response.setDepartment(updatedStudent.getDepartment());
        response.setCgpa(updatedStudent.getCgpa());

        return response;
        
    }

    // Delete student by Id.
    public String deleteStudentById(long id) {
        Student student = repository.findById(id)
                            .orElseThrow(() -> new StudentException("No student found with id: " + id));

        repository.delete(student);

        return "Student Deleted Successfully";
    }

    // Delete all student.
    public String deleteAllStudent() {
        if (repository.count() == 0) {
            return "No Student found.";
        }

        else {
            repository.deleteAll();
        }

        return "All student deleted successfully.";
    }
}
