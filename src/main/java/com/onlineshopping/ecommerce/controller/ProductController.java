package com.onlineshopping.ecommerce.controller;

import com.onlineshopping.ecommerce.model.Product;
import com.onlineshopping.ecommerce.model.Subcategory;
import com.onlineshopping.ecommerce.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public ResponseEntity<Collection<Product>> getAll(){
        Collection<Product> products = productService.findAll();
       return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
    }
    @GetMapping("/products/category/{categoryName}")
    public  ResponseEntity<Collection<Product>> getByCatgory(@PathVariable String categoryName){
        Collection<Product> products = productService.findByCategory(categoryName);
        return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
    }
    @GetMapping("/products/subcategory/{subcategoryName}")
    public ResponseEntity<Collection<Product>> getBySubcategory(@PathVariable String subcategoryName){
        Collection<Product> products = productService.findBySubcategory(subcategoryName);
        return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<String> save(@RequestBody Product product){
        productService.save(product);
        return  new ResponseEntity<String>(HttpStatus.CREATED);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        productService.delete(id);
        return  new ResponseEntity<String>(HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<Subcategory> update(@PathVariable String id, @RequestBody Subcategory updateSubcategory){
        Subcategory subcategory = updateSubcategory;
        subcategory.setId(id);
        return  new ResponseEntity<Subcategory>(subcategory, HttpStatus.OK);

    }

}
