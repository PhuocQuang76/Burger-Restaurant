package com.example.modules;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.modules.enums.ProductStatus;
import com.example.modules.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int product_id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "price", nullable = false)
    double price;

    @Column(name = "description", nullable = false)
    String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "seller", nullable = false)
    @JsonIgnore
    User seller;

    @Column(name = "statusid", nullable = false)
    ProductStatus statusid;

    @Column(name = "typeid")
    ProductType typeid;

    public Product() {
    }

    public Product(int product_id, String name, double price, String description, User seller, ProductStatus statusid,
            ProductType typeid) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.seller = seller;
        this.statusid = statusid;
        this.typeid = typeid;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public ProductStatus getStatusid() {
        return statusid;
    }

    public void setStatusid(ProductStatus statusid) {
        this.statusid = statusid;
    }

    public ProductType getTypeid() {
        return typeid;
    }

    public void setTypeid(ProductType typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        return "Product [description=" + description + ", name=" + name + ", price=" + price + ", product_id="
                + product_id + ", seller=" + seller + ", statusid=" + statusid + ", typeid=" + typeid + "]";
    }
}
