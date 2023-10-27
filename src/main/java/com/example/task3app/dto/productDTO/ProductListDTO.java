package com.example.task3app.dto.productDTO;

import com.example.task3app.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductListDTO {

    List<Product> productList;
}
