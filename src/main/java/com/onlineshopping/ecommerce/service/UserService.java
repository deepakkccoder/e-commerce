package com.onlineshopping.ecommerce.service;

import com.onlineshopping.ecommerce.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findOneById(String id);
    public User findByName(String name);
    public User save(User user);
    public void delete(String id);
}
