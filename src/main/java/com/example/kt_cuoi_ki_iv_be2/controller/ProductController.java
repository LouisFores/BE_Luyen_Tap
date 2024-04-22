package com.example.kt_cuoi_ki_iv_be2.controller;

import com.example.kt_cuoi_ki_iv_be2.model.People;
import com.example.kt_cuoi_ki_iv_be2.model.Product;
import com.example.kt_cuoi_ki_iv_be2.model.ProductDTO;
import com.example.kt_cuoi_ki_iv_be2.service.iml.PeopleService;
import com.example.kt_cuoi_ki_iv_be2.service.iml.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private PeopleService peopleService;
    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllStudents(@PageableDefault(5) Pageable pageable) {
        Page<Product> list =  productService.findAll(pageable);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO) {
        People people = peopleService.findById(productDTO.getIdPeople()).get();
        Product product = new Product(productDTO.getIdProduct(), productDTO.getNameProduct(), productDTO.getPrice(), people);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long idProduct, @RequestBody ProductDTO productDTO) {
        Optional<Product> productOptional = productService.findById(idProduct);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Product product = new Product(idProduct, productDTO.getNameProduct(), productDTO.getPrice(), productOptional.get().getPeople());
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long idProduct) {
        Optional<Product> productOptional = productService.findById(idProduct);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(idProduct);
        return new ResponseEntity<>("Giá trị đã xoá thành công", HttpStatus.OK);
    }

    @GetMapping("/near-price/{minPrice}/{maxPrice}")
    public ResponseEntity<Iterable<Product>> findProductByPriceBetween(
            @PathVariable("minPrice") BigDecimal minPrice,
            @PathVariable("maxPrice") BigDecimal maxPrice) {
        Iterable<Product> products = productService.findByPriceBetween(minPrice, maxPrice);
        if (!products.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search-name/{nameProduct}")
    public ResponseEntity<Iterable<Product>> findProductByName(@PathVariable("nameProduct") String nameProduct){
        Iterable<Product> products = productService.findProductByName(nameProduct);
        if (!products.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//    Cách 2 dùng RequestParam
//    http://localhost:8080/products/near-price?minPrice=20&maxPrice=2
//    @GetMapping("/products/near-price")
//    public String getNearPriceProducts(
//            @RequestParam("minPrice") double minPrice,
//            @RequestParam("maxPrice") double maxPrice) {
//
//    }

}
