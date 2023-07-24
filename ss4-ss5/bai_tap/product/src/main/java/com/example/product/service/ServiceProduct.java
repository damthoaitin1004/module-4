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
    public boolean add(Product product) {
        boolean check = iRepositoryProduct.add(product);
        return check;
    }

    @Override
    public boolean remove(int id) {
        boolean check = iRepositoryProduct.remove(id);
        return check;
    }

    @Override
    public boolean update(Product product) {
        boolean check = iRepositoryProduct.update(product);
        return check;
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
