package com.nz.nbp_converter.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

import java.sql.Date;


@Table(name="products")
@XStreamAlias("komputer")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XStreamOmitField
    private int id;
    @XStreamAlias("nazwa")
    private String name;
    @XStreamAlias("koszt_USD")
    private double usdPrice;

    public Product(String name, double usdPrice, double plnPrice, Date date) {

        this.name = name;
        this.usdPrice = usdPrice;
        this.plnPrice = plnPrice;
        this.date = date;
    }
    @XStreamAlias("koszt_PLN")
    private double plnPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XStreamAlias("data_ksiegowania")
    private Date date;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", usdPrice=" + usdPrice +
                ", plnPrice=" + plnPrice +
                ", date=" + date +
                '}';
    }

    public void setPlnPrice(double plnPrice) {
        this.plnPrice = plnPrice;
    }
}
