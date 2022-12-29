package com.nz.nbp_converter.entity;

import jakarta.persistence.*;

@Table(name="products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private double usdPrice;
    private double plnPrice;

    public Product(String name,  double usdPrice, double plnPrice) {
        this.name = name;

        this.usdPrice = usdPrice;
        this.plnPrice = plnPrice;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(double usdPrice) {
        this.usdPrice = usdPrice;
    }

    public double getPlnPrice() {
        return plnPrice;
    }

    public void setPlnPrice(double plnPrice) {
        this.plnPrice = plnPrice;
    }
}
