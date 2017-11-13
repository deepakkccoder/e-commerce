package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.Subcategory;

import java.util.List;

public interface SubcategoryService {
    public List<Subcategory> findAll();
    public Subcategory findOneById(String id);
    public Subcategory findByName(String name);
    public void save(Subcategory category);
    public void delete(String id);
}
