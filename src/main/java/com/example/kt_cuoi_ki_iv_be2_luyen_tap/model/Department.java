package com.example.kt_cuoi_ki_iv_be2_luyen_tap.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartment;

    @NotEmpty(message = "Ô dữ liệu không để trống")
    private String nameDepartment;

    public Department() {}
    public Department(@NotEmpty String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }
}
