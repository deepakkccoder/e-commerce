package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public Category findOneById(String id);
    public Category findByName(String name);
    public void save(Category category);
    public void delete(String id);

}
