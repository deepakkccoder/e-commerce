package com.onlineshopping.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value="/")
    public String home(){
        return "Welcome to E-Commerce Project";
    }
}
