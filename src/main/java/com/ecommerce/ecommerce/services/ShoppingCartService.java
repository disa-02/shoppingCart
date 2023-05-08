package com.ecommerce.ecommerce.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.CartItem;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ShoppingCart;
import com.ecommerce.ecommerce.repository.CartItemRepository;
import com.ecommerce.ecommerce.repository.ProductRepository;
import com.ecommerce.ecommerce.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ProductRepository productRepository;

    public void create(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }

    public void addProduct(Product product,ShoppingCart shoppingCart, int amount){ //veridicar cant producto??falta esto
        //veridicacion de existencia del producto y el shoppingcart
        Boolean existProduct = productRepository.existsById(product.getId());
        Boolean existShoppingCart = shoppingCartRepository.existsById(shoppingCart.getId());
        if(!existProduct || !existShoppingCart){
            throw new IllegalArgumentException("El producto o el carrito de compras no existe");
        }
        

        List<CartItem> ci = cartItemRepository.findByProductAndShoppingCart(product,shoppingCart);
        if(ci.size() == 0){
            CartItem cartItem = new CartItem(amount,product, shoppingCart);
            cartItemRepository.save(cartItem);
        }
        else{
            int newamount = ci.get(0).getamount() + amount;
            ci.get(0).setamount(newamount);
            cartItemRepository.save(ci.get(0));
        }        
    }

    public boolean delProduct(int productId, int shoppingCartId){ //borra todo
        cartItemRepository.deleteByProductIdAndShoppingCartId(productId, shoppingCartId);

        return true;
    }

    public void delProduct(int productId, int shoppingCartId,int amount){//borra la cantidad indicada

        List<CartItem> cartItem  = cartItemRepository.findByProductIdAndShoppingCartId(productId, shoppingCartId);
        if(cartItem.size() == 0){
            throw new IllegalArgumentException("El producto en el carrito seleccionado no existe");
        }
        int newAmount = cartItem.get(0).getamount() - amount;
        if(newAmount < 1){
            throw new IllegalArgumentException("Cantidad no valida");
        }
        cartItem.get(0).setamount(newAmount);
        cartItemRepository.save(cartItem.get(0));
    }
}
