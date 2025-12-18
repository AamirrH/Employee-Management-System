package com.codeexample.springbootrestapi.entities;


import jakarta.persistence.*;



import java.time.LocalDate;

@Entity

@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int employeeId;

    private String employeeName;

    private String email;

    private int age;

    private LocalDate dateofJoining;

    private boolean isActive;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateofJoining() {
        return dateofJoining;
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
