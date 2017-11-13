package com.onlineshopping.ecommerce.serviceImpl;

import com.onlineshopping.ecommerce.model.Order;
import com.onlineshopping.ecommerce.repository.OrderRepository;
import com.onlineshopping.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOneById(String id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Order.class);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(String id) {
        orderRepository.delete(id);
    }

    @Override
    public List<Order> findByUserId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("user.id").is(id));
        return mongoTemplate.find(query, Order.class);
    }
}
