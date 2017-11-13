package com.onlineshopping.ecommerce.serviceImpl;

import com.onlineshopping.ecommerce.model.ShoppingCart;
import com.onlineshopping.ecommerce.repository.ShoppingCartRepository;
import com.onlineshopping.ecommerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<ShoppingCart> findAll() {
       return shoppingCartRepository.findAll();

    }

    @Override
    public ShoppingCart findOneById(String id) {
        return shoppingCartRepository.findOne(id);
    }

    @Override
    public ShoppingCart findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, ShoppingCart.class);
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void delete(String id) {
        shoppingCartRepository.delete(id);
    }

    @Override
    public ShoppingCart findByUserId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("user.id").is(id));
        return mongoTemplate.findOne(query, ShoppingCart.class);
    }
}
