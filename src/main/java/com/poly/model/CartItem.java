package com.poly.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Properties;

@Entity
public class CartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "CartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "CreateTime")
    @Temporal(TemporalType.DATE)
    private Date createTime;

    public CartItem() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
