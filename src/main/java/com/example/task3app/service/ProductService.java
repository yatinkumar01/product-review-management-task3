package com.example.task3app.service;

import com.example.task3app.dto.productDTO.ProductCreateDTO;
import com.example.task3app.dto.productDTO.ProductDeleteDTO;
import com.example.task3app.dto.productDTO.ProductListDTO;
import com.example.task3app.exceptions.AlreadyExistException;
import com.example.task3app.exceptions.EmptyListException;
import com.example.task3app.exceptions.NotFoundException;
import com.example.task3app.model.Product;

public interface ProductService {

    ProductCreateDTO addProduct(Product product) throws AlreadyExistException;

    ProductListDTO getAllProducts() throws EmptyListException;

    Product getProductById(Integer id) throws NotFoundException;

    ProductCreateDTO updateProduct(Integer id, Product updatedProduct) throws NotFoundException;

    ProductDeleteDTO deleteProduct(Integer id) throws NotFoundException;
}


