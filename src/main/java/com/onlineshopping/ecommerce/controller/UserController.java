package com.onlineshopping.ecommerce.controller;


import com.onlineshopping.ecommerce.model.Order;
import com.onlineshopping.ecommerce.model.ShoppingCart;
import com.onlineshopping.ecommerce.model.User;
import com.onlineshopping.ecommerce.service.ShoppingCartService;
import com.onlineshopping.ecommerce.serviceImpl.OrderServiceImpl;
import com.onlineshopping.ecommerce.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @GetMapping("/users")
    public ResponseEntity<Collection<User>> getAll(){
        Collection<User> users = userService.findAll();
        return  new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable String id){
        User user = userService.findOneById(id);
        return  new ResponseEntity<User>(user, HttpStatus.OK);
    }
   @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user){
     User saveuser = userService.save(user);
      return  new ResponseEntity<User>(saveuser,HttpStatus.CREATED);

    }

   @DeleteMapping("/user/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        userService.delete(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

   @GetMapping("/user/{id}/order")
    public  ResponseEntity<Collection<Order>> getOrders(@PathVariable String id){
        Collection<Order> orders= orderService.findByUserId(id);
        return new ResponseEntity<Collection<Order>>(orders, HttpStatus.OK);
   }
   @GetMapping("/user/{id}/shoppingcart")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable String id){
       ShoppingCart shoppingCarts = shoppingCartService.findByUserId(id);
       return new ResponseEntity<ShoppingCart>(shoppingCarts, HttpStatus.OK);
   }
   @PutMapping("/user/{id}")
    public  ResponseEntity<User> update(@PathVariable String id, @RequestBody User updatedUser){
        User user = updatedUser;
        user.setId(id);
        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
   }
}
