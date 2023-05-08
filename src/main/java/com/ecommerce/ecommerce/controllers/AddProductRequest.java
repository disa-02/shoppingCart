package com.ecommerce.ecommerce.controllers;

import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ShoppingCart;

public class AddProductRequest {
    private Product product;
    private ShoppingCart shoppingCart;
    private int amount;
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
