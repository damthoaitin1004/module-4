package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public boolean add(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    @Transactional
    public boolean update(Product product) {
        try {
            Product productUpdate = getById(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());
            productUpdate.setQuantity(product.getQuantity());
            productUpdate.setDescription(product.getDescription());
            entityManager.merge(productUpdate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    @Transactional
    public boolean remove(int id) {
        try {
            Product product = getById(id);
            entityManager.remove(product);

        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Override
    @Transactional
    public Product getById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    @Transactional
    public List<Product> displayAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product ", Product.class);
        return query.getResultList();
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
