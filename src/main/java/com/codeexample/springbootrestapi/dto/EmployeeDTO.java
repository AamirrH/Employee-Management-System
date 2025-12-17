package com.codeexample.springbootrestapi.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private String employeeName;

    private int employeeId;

    private String email;

    private int age;

    private LocalDate dateofJoining;

    private boolean isActive;

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateofJoining() {
        return dateofJoining;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
