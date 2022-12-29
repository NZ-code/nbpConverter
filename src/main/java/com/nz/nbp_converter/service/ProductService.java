package com.nz.nbp_converter.service;


import com.nz.nbp_converter.Product;
import com.nz.nbp_converter.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> getProducts(){
        return productRepository.getProducts();
    }
    public void addProduct(Product product){
        productRepository.addProduct(product);
    }
}
