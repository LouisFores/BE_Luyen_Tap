package com.example.kt_cuoi_ki_iv_be2.service;

import com.example.kt_cuoi_ki_iv_be2.model.Product;

import java.math.BigDecimal;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    Iterable<Product> findProductByName(String nameProduct);
}
