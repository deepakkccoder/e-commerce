package com.onlineshopping.ecommerce.controller;

import com.onlineshopping.ecommerce.model.ShoppingCart;
import com.onlineshopping.ecommerce.serviceImpl.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShoppingcartController {
    @Autowired
    private ShoppingCartServiceImpl shoppingCartService;

    @GetMapping("/shoppingcart/{id}")
    public ResponseEntity<ShoppingCart> get(@PathVariable String id){
        ShoppingCart shoppingCart = shoppingCartService.findOneById(id);
        return  new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
    }
   @PostMapping("/shoppingcart")
    public ResponseEntity<String> save(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.save(shoppingCart);
        return new ResponseEntity<String>(HttpStatus.OK);
   }
   @DeleteMapping("/shoppingcart/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        shoppingCartService.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
   }
   @PutMapping("/shoppingcart/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody ShoppingCart updateshoppingCart){
        ShoppingCart shoppingCart = updateshoppingCart;
        shoppingCart.setId(id);
        shoppingCartService.save(shoppingCart);
        return new ResponseEntity<String>(HttpStatus.OK);
   }
}
