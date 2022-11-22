package com.plenilune.SpringBootPractice.entity;

import javax.persistence.*;

@Entity
@Table(name="productitem")
public class ProductItemEntity {
    public ProductItemEntity() {

    }

    public  ProductItemEntity(Long id, String name, Double price, Integer quantity) {
        super(); // why?
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
