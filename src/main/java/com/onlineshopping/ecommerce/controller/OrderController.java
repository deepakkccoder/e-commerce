package com.onlineshopping.ecommerce.controller;

import com.onlineshopping.ecommerce.model.Order;
import com.onlineshopping.ecommerce.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getById(@PathVariable String id){
        return new ResponseEntity<Order>(orderService.findOneById(id), HttpStatus.OK);
    }
    @PostMapping("/order")
    public  ResponseEntity<Order> save(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.save(order), HttpStatus.OK);
    }
    @PutMapping("/order/{id}")
    public ResponseEntity<Order> update(@PathVariable String id, @RequestBody Order updateorder){
        Order order = updateorder;
        order.setId(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }
}
