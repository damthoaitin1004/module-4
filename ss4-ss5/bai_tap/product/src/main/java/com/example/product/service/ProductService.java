package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public boolean add(Product product) {
        boolean check = iProductRepository.add(product);
        return check;
    }

    @Override
    public boolean remove(int id) {
        boolean check = iProductRepository.remove(id);
        return check;
    }

    @Override
    public boolean update(Product product) {
        boolean check = iProductRepository.update(product);
        return check;
    }

    @Override
    public List<Product> displayAll() {
        return iProductRepository.displayAll();
    }

    @Override
    public List<Product> searchName(String name) {
        return iProductRepository.searchName(name);
    }

    @Override
    public Product getById(int id) {
        return iProductRepository.getById(id);
    }
}
