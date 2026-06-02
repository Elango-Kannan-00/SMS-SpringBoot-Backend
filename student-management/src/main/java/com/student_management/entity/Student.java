package com.student_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Student fields
  
    private String name;
    private String email;
    private String department;
    private long mobileNo;
    private int age;
    private double cgpa;
    
    // Default constructor
    public Student () {}

    // Parameterized constructor
    public Student (
        long id, 
        String name, 
        String email, 
        String department,
        long mobileNo,
        int age,
        double cgpa
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.mobileNo = mobileNo;
        this.age = age;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

}
