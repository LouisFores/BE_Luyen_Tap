package com.example.kt_cuoi_ki_iv_be2.model;

import jakarta.persistence.*;

import javax.swing.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeople;

    @NotEmpty
    @Size(min = 5, max = 30)
    private String fullName;

    @Min(18)
    private int age;

    public People() {}

    public People(@NotEmpty @Size(min = 5, max = 30) Spring fullName, @Min(18) int age) {
        this.fullName = fullName.toString();
        this.age = age;
    }
    public Long getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(Long idPeople) {
        this.idPeople = idPeople;
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
}
