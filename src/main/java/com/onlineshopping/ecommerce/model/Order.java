package com.onlineshopping.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private Date dateCreated;
    private Date dateShipped;
    private Status status;

}
