package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

    public void update(Product product){
        productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();

    }

    public Optional<Product> get(int id){
        return productRepository.findById(id);
    }

    // public void delteOne(Product product){
    //     Optional<Product> p = productRepository.findById(product.getId());
    //     int amoung = p.get().getAmoung();
    //     if(amoung > 0){
    //         p.get().setAmoung(amoung -1);
    //     }
    //     productRepository.save(p.get());
    // }

    
    
}
