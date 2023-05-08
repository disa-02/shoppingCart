package com.ecommerce.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ShoppingCart;
import com.ecommerce.ecommerce.services.ShoppingCartService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/shoppingCart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(){
        shoppingCartService.create(new ShoppingCart());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest addProductRequest){
        shoppingCartService.addProduct(addProductRequest.getProduct(), addProductRequest.getShoppingCart(), addProductRequest.getAmount());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delProduct(@RequestParam int IdProduct,@RequestParam int idShoppingCart){
        Boolean response = shoppingCartService.delProduct(IdProduct, idShoppingCart);
        if (response){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/substract")
    public ResponseEntity<?> substractProduct(@RequestParam int IdProduct,@RequestParam int idShoppingCart, @RequestParam int amount){
        shoppingCartService.delProduct(IdProduct, idShoppingCart, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
