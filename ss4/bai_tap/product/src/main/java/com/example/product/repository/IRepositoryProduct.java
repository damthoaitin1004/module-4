package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;

public interface IRepositoryProduct {
    void add(Product product);
    void remove(int id);
    List<Product> displayAll();
    List<Product> searchName(String name);
    Product getById(int id);
   void update(Product product);
}
