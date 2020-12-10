package com.yxy.market1.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "decription")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private String status;
}
