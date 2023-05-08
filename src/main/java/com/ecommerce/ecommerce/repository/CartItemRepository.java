package com.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entities.CartItem;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ShoppingCart;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByProductAndShoppingCart(Product product,ShoppingCart shoppingCart);
    List<CartItem> findByProductIdAndShoppingCartId(int product_id,int shopping_cart_id);

    void deleteByProductIdAndShoppingCartId(int product_id, int shopping_cart_id);
}
