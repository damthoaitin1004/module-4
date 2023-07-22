package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryProduct implements IRepositoryProduct {
    private static Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1,new Product(1,"Banh",10000.0,100,"Ngon"));
    }

    @Override
    public void add(Product product) {
        int newId = productList.size()+1;

        product.setId(newId);
        productList.put(newId,product);
    }

    @Override
    public void update(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Product getById(int id) {
        for (Integer key:productList.keySet()) {
               if (productList.get(key).getId()==id){
                   return productList.get(key);
               }
        }
        return null;
    }

    @Override
    public List<Product> displayAll() {
        List<Product> products = new ArrayList<>(productList.values());
        return products;
    }

    @Override
    public List<Product> searchName(String name) {
        List<Product> searchName = new ArrayList<>();
        for (Product p : displayAll()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                searchName.add(p);
            }
        }
        return searchName;
    }
}
