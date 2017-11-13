package com.onlineshopping.ecommerce.serviceImpl;

import com.onlineshopping.ecommerce.model.Subcategory;
import com.onlineshopping.ecommerce.repository.SubcategoryRepository;
import com.onlineshopping.ecommerce.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryServiceImpl implements SubcategoryService{
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    @Override
    public Subcategory findOneById(String id) {
        return subcategoryRepository.findOne(id);
    }

    @Override
    public Subcategory findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, Subcategory.class);
    }

    @Override
    public void save(Subcategory category) {
        subcategoryRepository.save(category);
    }

    @Override
    public void delete(String id) {
        subcategoryRepository.delete(id);
    }
}
