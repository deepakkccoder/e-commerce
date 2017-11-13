package com.onlineshopping.ecommerce.controller;

import com.onlineshopping.ecommerce.model.Subcategory;
import com.onlineshopping.ecommerce.serviceImpl.SubcategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class SubcategoryController {
    @Autowired
    private SubcategoryServiceImpl subcategoryService;

    @GetMapping("/subcategories")
    public ResponseEntity<Collection<Subcategory>> getAll(){
        Collection<Subcategory> subcategories = subcategoryService.findAll();
        return new ResponseEntity<Collection<Subcategory>>(subcategories, HttpStatus.OK);
    }
    @GetMapping("/subcategory/{id}")
    public ResponseEntity<Subcategory> get(@PathVariable String id){
        Subcategory subcategory = subcategoryService.findOneById(id);
        return new ResponseEntity<Subcategory>(subcategory, HttpStatus.OK);
    }
    @PostMapping("/subcategory")
    public ResponseEntity<String> save(@RequestBody Subcategory subcategory){
       subcategoryService.save(subcategory);
       return new ResponseEntity<String>(HttpStatus.CREATED);
    }
    @DeleteMapping("/subcategory/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        subcategoryService.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @PutMapping("/subcatogory/{id}")
    public  ResponseEntity<Subcategory> update(@PathVariable String id, @RequestBody Subcategory updateSubcategory){
        Subcategory subcategory = updateSubcategory;
        subcategory.setId(id);
        subcategoryService.save(subcategory);
        return new ResponseEntity<Subcategory>(subcategory, HttpStatus.OK);
    }
}
