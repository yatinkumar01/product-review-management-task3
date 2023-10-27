package com.example.task3app.controller;

import com.example.task3app.dto.productDTO.ProductCreateDTO;
import com.example.task3app.dto.productDTO.ProductDeleteDTO;
import com.example.task3app.dto.productDTO.ProductListDTO;
import com.example.task3app.model.Product;
import com.example.task3app.service.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create a new product
    @PostMapping("/products")
    @SneakyThrows
    ResponseEntity<ProductCreateDTO> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    // Retrieve a list of all products
    @GetMapping("/products")
    @SneakyThrows
    ResponseEntity<ProductListDTO> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    // Retrieve a product by its ID
    @GetMapping("/products/{id}")
    @SneakyThrows
    ResponseEntity<Product> getProductByID(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.FOUND);
    }

    // Update a product by its ID
    @PutMapping("/products/{id}")
    @SneakyThrows
    ResponseEntity<ProductCreateDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return new ResponseEntity(productService.updateProduct(id, product), HttpStatus.OK);
    }

    // Delete a product by its ID
    @DeleteMapping("/products/{id}")
    @SneakyThrows
    ResponseEntity<ProductDeleteDTO> deleteProduct(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
