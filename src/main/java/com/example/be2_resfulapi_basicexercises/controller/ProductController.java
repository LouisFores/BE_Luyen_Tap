package com.example.be2_resfulapi_basicexercises.controller;

import com.example.be2_resfulapi_basicexercises.model.Product;
import com.example.be2_resfulapi_basicexercises.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    //Tìm kiếm theo tên gần đúng
    @GetMapping("/search/{variable}")
    public ResponseEntity<Iterable<Product>> showAllProductByName(@PathVariable("variable") String variable){
        Iterable<Product> products = productRepository.findByName(variable);
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
    }
    //Sắp xếp tăng dần
    @GetMapping("/findProductsDesc")
    public ResponseEntity<Iterable<Product>> showAllProductsDesc(){
        Iterable<Product> products = productRepository.findProductsDesc();
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
    }
    //Sắp xếp 4 giá trị price lớn nhất
    @GetMapping("/findProductsTop4")
    public ResponseEntity<Iterable<Product>> showAllProductsTop4(){
        Iterable<Product> products = productRepository.findProductsTop4();
        if (products == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
    }
}
