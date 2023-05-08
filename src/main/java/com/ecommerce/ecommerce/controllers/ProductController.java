package com.ecommerce.ecommerce.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping(value="/get")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @PostMapping(value="/save")
    public ResponseEntity<?> save(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value="/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id){
        Optional<Product> p = productService.get(id);
        if( p.isEmpty() ){
            return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
        }
        productService.save(p.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Product> p = productService.get(id);
        if( p.isEmpty() ){
            return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
        }
        productService.delete(p.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/get/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        Optional<Product> p = productService.get(id);
        if( p.isEmpty() ){
            return new ResponseEntity<>("El producto no existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p.get(),HttpStatus.OK);
    }
    
}
