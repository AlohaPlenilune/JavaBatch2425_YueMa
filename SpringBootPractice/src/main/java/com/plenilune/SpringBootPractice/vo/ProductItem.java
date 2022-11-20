package com.plenilune.SpringBootPractice.vo;

import com.plenilune.SpringBootPractice.entity.ProductItemEntity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductItem {

    private Long id;

    @NotNull
    private String name;

    private Double price;

    @Max(100000)
    @Min(0)
    private Integer quantity;

    public ProductItem() {

    }

    public ProductItem(Long id, String name, Double price, Integer quantity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


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
