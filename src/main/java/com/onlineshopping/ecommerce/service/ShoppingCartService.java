package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    public List<ShoppingCart> findAll();
    public ShoppingCart findOneById(String id);
    public ShoppingCart findByName(String name);
    public void save(ShoppingCart shoppingCart);
    public void delete(String id);
    public ShoppingCart findByUserId(String id);

}
