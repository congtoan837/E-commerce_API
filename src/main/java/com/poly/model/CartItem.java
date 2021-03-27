package com.poly.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "CartId")
    private int CartId;
    @Column(name = "ProductId")
    private int ProductId;
    @Column(name = "Quantity")
    private int Quantity;

    public CartItem() {
    }

    public CartItem(Integer id, int cartId, int productId, int quantity) {
        Id = id;
        CartId = cartId;
        ProductId = productId;
        this.Quantity = quantity;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public int getCartId() {
        return CartId;
    }
    public void setCartId(int cartId) {
        CartId = cartId;
    }

    public int getProductId() {
        return ProductId;
    }
    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }
}
