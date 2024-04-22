package com.example.kt_cuoi_ki_iv_be2.service.iml;

import com.example.kt_cuoi_ki_iv_be2.model.Product;
import com.example.kt_cuoi_ki_iv_be2.repository.IProductRepository;
import com.example.kt_cuoi_ki_iv_be2.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return iProductRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public Iterable<Product> findProductByName(String nameProduct) {
        return iProductRepository.findProductByNameProductContaining(nameProduct);
    }
}
