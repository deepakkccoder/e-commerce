package com.onlineshopping.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Month;
import java.time.Year;

@Document(collection = "creditcard")
public class CreditCard {
    @Id
    private String id;
    private Integer number;
    private String cardHolderName;
    private Month expiryMonth;
    private Year expiryYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Month getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(Month expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public Year getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(Year expiryYear) {
        this.expiryYear = expiryYear;
    }
}
