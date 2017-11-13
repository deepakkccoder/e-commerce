package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product findOneById(String id);
    public Product findByName(String name);
    public void save(Product product);
    public void delete(String id);
    public List<Product> findBySubcategory(String subcategoryName);
    public List<Product> findByCategory(String categoryName);
}
