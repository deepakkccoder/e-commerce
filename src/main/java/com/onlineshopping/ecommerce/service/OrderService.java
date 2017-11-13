package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> findAll();
    public Order findOneById(String id);
    public Order findByName(String name);
    public Order save(Order order);
    public void delete(String id);
    public List<Order> findByUserId(String id);
}
