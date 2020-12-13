package com.yxy.market1.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "decription")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String status;

    @Column(name = "picture")
    private String pictureAddr;

//    @Column(name = "releaseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

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
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPictureAddr() {
        return pictureAddr;
    }

    public void setPictureAddr(String pictureAddr) {
        this.pictureAddr = pictureAddr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
