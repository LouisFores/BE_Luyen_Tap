package com.example.kt_cuoi_ki_iv_be2_luyen_tap.model;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStaff;

    @NotEmpty(message = "Dữ liệu không để trống")
    @Size(min = 5, max = 30)
    private String fullName;

    @Min(20)
    private int age;

    @NotEmpty(message = "Dữ liệu không để trống")
    @Min(2000)
    private double salary;

    @ManyToOne
    @JoinColumn(name = "idDepartment")
    private Department department;

    public Staff() {}

    public Staff(@NotEmpty @Size(min = 5, max = 30) String fullName,
                 @Min(20) int age,
                 @NotEmpty(message = "Dữ liệu không để trống") @Min(2000) double salary) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
    }

    public Long getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Long idStaff) {
        this.idStaff = idStaff;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
