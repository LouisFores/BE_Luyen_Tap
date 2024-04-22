package com.example.kt_cuoi_ki_iv_be2.model;

public class ProductDTO {
    private Long idProduct;
    private String nameProduct;
    private double price;
    private Long idPeople;
    public ProductDTO() {}

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

    public Long getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(Long idPeople) {
        this.idPeople = idPeople;
    }
}
