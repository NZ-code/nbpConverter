package com.nz.nbp_converter.service;


import com.nz.nbp_converter.entity.Product;
import com.nz.nbp_converter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService( ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
}
