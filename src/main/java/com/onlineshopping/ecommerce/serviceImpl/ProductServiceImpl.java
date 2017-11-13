package com.onlineshopping.ecommerce.serviceImpl;

import com.onlineshopping.ecommerce.model.Product;
import com.onlineshopping.ecommerce.repository.ProductRepository;
import com.onlineshopping.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired private MongoTemplate mongoTemplate;



    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOneById(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findOne(name);
    }

    @Override
    public void save(Product product) {
         productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findBySubcategory(String subcategoryName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("subcategory.name").is(subcategoryName));
        List<Product> products =mongoTemplate.find(query, Product.class);
        return products;
    }

    @Override
    public List<Product> findByCategory(String categoryName) {
        return null;
    }
}
