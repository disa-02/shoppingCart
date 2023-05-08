package com.ecommerce.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int amount;
    @ManyToOne
    private Product product;
    @ManyToOne
    private ShoppingCart shoppingCart;
    
    public CartItem() {
    }
    public CartItem(int amount, Product product, ShoppingCart shopingCart) {
        this.amount = amount;
        this.product = product;
        this.shoppingCart = shopingCart;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getamount() {
        return amount;
    }
    public void setamount(int amount) {
        this.amount = amount;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public ShoppingCart getShopingCart() {
        return shoppingCart;
    }
    public void setShopingCart(ShoppingCart shopingCart) {
        this.shoppingCart = shopingCart;
    }

    
}
