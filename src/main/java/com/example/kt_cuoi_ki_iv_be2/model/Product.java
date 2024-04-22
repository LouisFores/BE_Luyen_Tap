package com.example.kt_cuoi_ki_iv_be2.model;

import jakarta.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @NotEmpty
    @Size(min = 5, max = 30)
    private String nameProduct;

    @NotEmpty
    @Min(5000)
    private double price;

    @ManyToOne
    @JoinColumn(name = "idPeople")
    private People people;

    public Product() {}

    public Product(Long idProduct, String nameProduct, double price, People people) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.people = people;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
