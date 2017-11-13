package com.onlineshopping.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="orderdetail")
public class OrderDetail {
    @Id
    private String id;

}
