package com.onlineshopping.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "brand")
public class Brand {
    @Id
    private String id;
    private String name;
    private String desrciption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesrciption() {
        return desrciption;
    }

    public void setDesrciption(String desrciption) {
        this.desrciption = desrciption;
    }
}
