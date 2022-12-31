package com.nz.nbp_converter.service;


import com.nz.nbp_converter.entity.Product;
import com.nz.nbp_converter.repository.ProductRepository;
import com.nz.nbp_converter.repository.XMLProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private XMLProductRepository xmlProductRepository;
    @Autowired
    public ProductService( ProductRepository productRepository){

        this.productRepository = productRepository;
        this.xmlProductRepository = XMLProductRepository.getInstance();
    }
    public List<Product> getProducts(){

        return productRepository.findAll();
    }
    public void addProduct(Product product){
        xmlProductRepository.addProduct(product);
        productRepository.save(product);
    }
    public List<Product> getProductsByName(String name){
        return productRepository.findAllByLikeName(name);
    }
    public List<Product> getProductsByNameAndDate(String name, Date date){
        return productRepository.findAllByLikeNameAndDate(name,date);
    }

    public List<Product> getProductsByDate(Date date) {
        return productRepository.findAllByDate(date);
    }
}
