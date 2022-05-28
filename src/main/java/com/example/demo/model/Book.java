package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private Integer id;

    private String name;

    private String author;

    private BigDecimal price;

    private Date cationdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCationdate() {
        return cationdate;
    }

    public void setCationdate(Date cationdate) {
        this.cationdate = cationdate;
    }
}