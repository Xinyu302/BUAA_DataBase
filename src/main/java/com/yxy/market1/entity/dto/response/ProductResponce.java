package com.yxy.market1.entity.dto.response;

public class ProductResponce {
    private Integer id;
    private String good_name;
    private Double price;
    private String photo_address;

    public ProductResponce(Integer id, String good_name, Double price, String photo_address) {
        this.id = id;
        this.good_name = good_name;
        this.price = price;
        this.photo_address = photo_address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPhoto_address() {
        return photo_address;
    }

    public void setPhoto_address(String photo_address) {
        this.photo_address = photo_address;
    }
}
