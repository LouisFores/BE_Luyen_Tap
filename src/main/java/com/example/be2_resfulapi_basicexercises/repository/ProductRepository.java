package com.example.be2_resfulapi_basicexercises.repository;

import com.example.be2_resfulapi_basicexercises.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :name, '%')")
    Iterable<Product> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Product p ORDER BY p.price DESC",nativeQuery = true)
    List<Product> findProductsDesc();

    @Query(value = "SELECT * FROM Product p ORDER BY p.price DESC limit 4", nativeQuery = true)
    Iterable<Product> findProductsTop4();

}
