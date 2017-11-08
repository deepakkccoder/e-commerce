package com.onlineshopping.ecommerce.repository;

import com.onlineshopping.ecommerce.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String>{
}
