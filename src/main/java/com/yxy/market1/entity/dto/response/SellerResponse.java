package com.yxy.market1.entity.dto.response;

public class SellerResponse {
    private String phone;
    private String address;
    private Integer id;

    public SellerResponse(String phone, String address, Integer id) {
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
