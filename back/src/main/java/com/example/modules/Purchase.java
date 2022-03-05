package com.example.modules;

import java.sql.Timestamp;

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

import com.example.modules.enums.PurchasesStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int purchase_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = false)
    Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer", nullable = false)
    @JsonIgnore
    User buyer;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "purchase", nullable = false)
    Timestamp purchase;

    @Column(name = "delivery")
    Timestamp delivery;

    @Column(name = "statusid", nullable = false)
    PurchasesStatus statusid;

    public Purchase() {
    }

    public Purchase(int purchase_id, Product product, User buyer, String address, Timestamp purchase,
            Timestamp delivery, PurchasesStatus statusid) {
        this.purchase_id = purchase_id;
        this.product = product;
        this.buyer = buyer;
        this.address = address;
        this.purchase = purchase;
        this.delivery = delivery;
        this.statusid = statusid;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getPurchase() {
        return purchase;
    }

    public void setPurchase(Timestamp purchase) {
        this.purchase = purchase;
    }

    public Timestamp getDelivery() {
        return delivery;
    }

    public void setDelivery(Timestamp delivery) {
        this.delivery = delivery;
    }

    public PurchasesStatus getStatusid() {
        return statusid;
    }

    public void setStatusid(PurchasesStatus statusid) {
        this.statusid = statusid;
    }

    @Override
    public String toString() {
        return "Purchase [address=" + address + ", buyer=" + buyer + ", delivery=" + delivery + ", product=" + product
                + ", purchase=" + purchase + ", purchase_id=" + purchase_id + ", statusid=" + statusid + "]";
    }

}
