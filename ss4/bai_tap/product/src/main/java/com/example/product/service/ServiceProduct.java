package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.IRepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct implements IServiceProduct {
    @Autowired
    private IRepositoryProduct iRepositoryProduct;

    @Override
    public void add(Product product) {
        iRepositoryProduct.add(product);
    }

    @Override
    public void remove(int id) {
        iRepositoryProduct.remove(id);
    }

    @Override
    public void update(Product product) {
        iRepositoryProduct.update(product);
    }

    @Override
    public List<Product> displayAll() {
        return iRepositoryProduct.displayAll();
    }

    @Override
    public List<Product> searchName(String name) {
        return iRepositoryProduct.searchName(name);
    }

    @Override
    public Product getById(int id) {
        return iRepositoryProduct.getById(id);
    }
}
