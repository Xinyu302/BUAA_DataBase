package com.yxy.market1.entity.dto.form;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class ProductForm {
    private String name;

    private String catagory;

    private String decription;

    private Double price;

//    private String status;

    private int sellerId;

    private MultipartFile photo;

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
