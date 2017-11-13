package com.onlineshopping.ecommerce.controller;

import com.onlineshopping.ecommerce.model.Category;
import com.onlineshopping.ecommerce.serviceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Collection<Category>> getAll(){
        Collection<Category> categories = categoryService.findAll();
        return  new ResponseEntity<Collection<Category>>(categories, HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public  ResponseEntity<Category> getById(@PathVariable String id){
        Category category = categoryService.findOneById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
    @PostMapping("/category")
    public  ResponseEntity<String> save(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<String>(HttpStatus.CREATED) ;
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        categoryService.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
