package com.student_management.dto;

public class StudentResponseDto {
    
    // Student response fields.
    private long id;
    private String name;
    private String department;
    private String cgpa;

    // Getters and Setters.
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getCgpa() {
        return cgpa;
    }
    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }
    
}
