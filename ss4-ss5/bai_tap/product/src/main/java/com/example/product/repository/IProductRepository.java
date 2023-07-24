package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;

public interface IProductRepository {
    boolean add(Product product);
    boolean remove(int id);
    List<Product> displayAll();
    List<Product> searchName(String name);
    Product getById(int id);
   boolean update(Product product);
}
