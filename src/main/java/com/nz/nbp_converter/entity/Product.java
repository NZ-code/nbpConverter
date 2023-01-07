package com.nz.nbp_converter.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Table(name="products")
@XStreamAlias("komputer")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XStreamOmitField
    private int id;
    @NotBlank(message = "Name cannot be blank")
    @XStreamAlias("nazwa")
    private String name;
    @Min(value = 0,message = "Price must be higher than 0")
    @XStreamAlias("koszt_USD")
    private double usdPrice;
    @XStreamAlias("koszt_PLN")
    private double plnPrice;

    @Past(message = "Date must be on the past")
    @XStreamAlias("data_ksiegowania")
    private Date date;
    public Product(String name, double usdPrice, double plnPrice, Date date) {

        this.name = name;
        this.usdPrice = usdPrice;
        this.plnPrice = plnPrice;
        this.date = date;
    }

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
