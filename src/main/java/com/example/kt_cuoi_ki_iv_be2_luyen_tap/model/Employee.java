package com.example.kt_cuoi_ki_iv_be2_luyen_tap.model;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @NotEmpty(message = "Dữ liệu không để trống")

    private String idEmployee;

    @NotEmpty(message = "Dữ liệu không để trống")
    @Size(min = 5, max = 30)
    private String name;

    @Min(20)
    private int age;

    @NotEmpty(message = "Dữ liệu không để trống")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "idDepartment")
    private Department department;

    public Employee() {}

    public Employee(@NotEmpty @Size(min = 5, max = 30) String name,
                 @Min(20) int age,
                 @NotEmpty(message = "Dữ liệu không để trống") @Min(2000) double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String idEmployee, String name, int age, double salary, Department department) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
