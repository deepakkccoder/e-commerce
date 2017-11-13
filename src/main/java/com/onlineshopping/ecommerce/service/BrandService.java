package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> findAll();
    public Brand findOneById(String id);
    public Brand findByName(String name);
    public void save(Brand brand);
    public void delete(String id);

}
