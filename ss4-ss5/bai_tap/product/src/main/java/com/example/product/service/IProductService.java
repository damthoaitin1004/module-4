package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface IProductService {
    boolean add(Product product);
    boolean remove(int id);
    List<Product> displayAll();
    List<Product> searchName(String name);
    Product getById(int id);
    boolean update(Product product);
}
