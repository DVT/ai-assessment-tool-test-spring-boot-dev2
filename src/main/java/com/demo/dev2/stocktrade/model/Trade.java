package com.demo.dev2.stocktrade.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.time.ZonedDateTime;

@Entity
public class Trade {
    @Id
    private Long id;
    private String type;

    @ManyToOne
    private User user;
    private String symbol;

    @DecimalMin("10")
    @DecimalMax("30")
    private Integer shares;

    @DecimalMin("130.42")
    @DecimalMax("195.65")
    private Float price;

    private ZonedDateTime timestamp;
    
    public Trade() {
    }
    
    public Trade(Long id, String type, User user, String symbol, Integer quantity, Float price, ZonedDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.symbol = symbol;
        this.shares = quantity;
        this.price = price;
        this.timestamp = timestamp;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public Integer getShares() {
        return this.shares;
    }
    
    public void setShares(Integer shares) {
        this.shares = shares;
    }
    
    public Float getPrice() {
        return this.price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
