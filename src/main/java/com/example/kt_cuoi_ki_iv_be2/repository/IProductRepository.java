package com.example.kt_cuoi_ki_iv_be2.repository;

import com.example.kt_cuoi_ki_iv_be2.model.People;
import com.example.kt_cuoi_ki_iv_be2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface IProductRepository extends CrudRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
    Iterable<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    Iterable<Product> findProductByNameProductContaining(String nameProduct);
}
