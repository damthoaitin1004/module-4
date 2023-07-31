package com.example.card.model;

import com.example.card.dto.ProductDto;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<ProductDto,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<ProductDto,Integer> products) {
        this.products = products;
    }

    public Map<ProductDto,Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public void addProduct(ProductDto productDto){
       if (products.containsKey(productDto)){
           Integer currentValue = products.get(productDto);
           products.replace(productDto,currentValue + 1);
       }else {
           products.put(productDto,1);
       }
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void removeProduct(ProductDto productDto){
        if (products.containsKey(productDto)){
            Integer currentValue = products.get(productDto);
            if (currentValue != 0){
                products.replace(productDto,currentValue - 1);
            }
        }else {
            products.put(productDto,1);
        }
    }
    public void clearAll(){
        products.clear();
    }
    public int getSize(){
       return products.size();
    }
}