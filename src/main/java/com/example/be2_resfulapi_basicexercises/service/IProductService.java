package com.example.be2_resfulapi_basicexercises.service;

import com.example.be2_resfulapi_basicexercises.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void remove(Long id);
}
