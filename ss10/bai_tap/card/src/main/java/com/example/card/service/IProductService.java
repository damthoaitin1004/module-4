package com.example.card.service;

import com.example.card.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
