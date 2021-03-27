package com.poly.model;

import java.io.Serializable;

public class OrderDTO implements Serializable {
    private Integer Id;
    private Product product;
    private int Quantity;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, Product product, int quantity) {
        Id = id;
        this.product = product;
        Quantity = quantity;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
