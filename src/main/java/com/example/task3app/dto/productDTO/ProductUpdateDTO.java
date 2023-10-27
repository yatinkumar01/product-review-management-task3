package com.example.task3app.dto.productDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor@NoArgsConstructor
public class ProductUpdateDTO {

    private String Name;
    private BigDecimal price;
}
