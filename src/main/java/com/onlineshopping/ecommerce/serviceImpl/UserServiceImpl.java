package com.onlineshopping.ecommerce.serviceImpl;

import com.onlineshopping.ecommerce.model.User;
import com.onlineshopping.ecommerce.repository.UserRepository;
import com.onlineshopping.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOneById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }
}
