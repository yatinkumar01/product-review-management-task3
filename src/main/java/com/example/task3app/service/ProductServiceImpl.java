package com.example.task3app.service;

import com.example.task3app.dto.productDTO.ProductCreateDTO;
import com.example.task3app.dto.productDTO.ProductDeleteDTO;
import com.example.task3app.dto.productDTO.ProductListDTO;
import com.example.task3app.dto.productDTO.ProductUpdateDTO;
import com.example.task3app.exceptions.AlreadyExistException;
import com.example.task3app.exceptions.EmptyListException;
import com.example.task3app.exceptions.NotFoundException;
import com.example.task3app.model.Product;
import com.example.task3app.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    /**
     * Add a new product to the database.
     *
     * @param product The product to be added.
     * @return A DTO (Data Transfer Object) representing the newly created product.
     * @throws AlreadyExistException if a product with the same ID already exists.
     */
    @Override
    public ProductCreateDTO addProduct(Product product) throws AlreadyExistException {
        if (productRepo.existsById(product.getId())) {
            throw new AlreadyExistException("Product with ID " + product.getId() + " already exists.");
        }
        Product savedProduct = productRepo.save(product);
        return new ProductCreateDTO(savedProduct.getId());
    }

    /**
     * Retrieve a list of all products from the database.
     *
     * @return A DTO containing a list of products.
     * @throws EmptyListException if no products are found in the database.
     */
    @Override
    public ProductListDTO getAllProducts() throws EmptyListException {
        List<Product> products = productRepo.findAll();
        if (products.isEmpty()) {
            throw new EmptyListException("No products found.");
        }
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setProductList(products);
        return productListDTO;
    }

    /**
     * Get a product by its ID from the database.
     *
     * @param id The ID of the product to retrieve.
     * @return The product with the specified ID.
     * @throws NotFoundException if the product with the specified ID is not found.
     */
    @Override
    public Product getProductById(Integer id) throws NotFoundException {
        return productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found."));
    }

    /**
     * Update a product by its ID.
     *
     * @param id            The ID of the product to update.
     * @param updatedProduct The updated product information.
     * @return A DTO representing the updated product information.
     * @throws NotFoundException if the product with the specified ID is not found.
     */
    @Override
    public ProductCreateDTO updateProduct(Integer id, Product updatedProduct) throws NotFoundException {
        if (!productRepo.existsById(id)) {
            throw new NotFoundException("Product with ID " + id + " not found.");
        }
        Product updatedProductDone = productRepo.save(updatedProduct);
        ProductCreateDTO productDTO = new ProductCreateDTO();
        ProductUpdateDTO productUpdateDTO = new ProductUpdateDTO();
        if (updatedProductDone.getName() != null) {
            productUpdateDTO.setName(updatedProductDone.getName());
        }
        if (updatedProductDone.getPrice() != null) {
            productDTO.setId(updatedProductDone.getId());
        }
        return productDTO;
    }

    /**
     * Delete a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return A DTO with information about the deleted product.
     * @throws NotFoundException if the product with the specified ID is not found.
     */
    @Override
    public ProductDeleteDTO deleteProduct(Integer id) throws NotFoundException {
        if (!productRepo.existsById(id)) {
            throw new NotFoundException("Product with ID " + id + " not found.");
        }
        ProductDeleteDTO productDeleteDTO = new ProductDeleteDTO();
        try {
            productRepo.deleteById(id);
            productDeleteDTO.setId(id);
            productDeleteDTO.setMessage("Product Deleted Successfully");
            return productDeleteDTO;
        } catch (Exception exception) {
            exception.getMessage();
            productDeleteDTO.setId(id);
            productDeleteDTO.setMessage("No Deleted");
            return productDeleteDTO;
        }
    }
}
