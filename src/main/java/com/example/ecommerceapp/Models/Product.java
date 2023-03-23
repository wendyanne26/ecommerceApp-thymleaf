package com.example.ecommerceapp.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String productName;
    private String productCategory;
    private int quantity;
    private double price;
    private String productImage;
}
