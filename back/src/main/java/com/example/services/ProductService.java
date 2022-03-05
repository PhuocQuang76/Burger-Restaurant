package com.example.services;

import java.util.List;

import javax.transaction.Transactional;

import com.example.modules.Product;
import com.example.modules.User;
import com.example.modules.enums.ProductStatus;
import com.example.repository.ProductRepo;
import com.example.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    private ProductRepo pr;
    private UserRepo ur;

    public ProductService() {
    }

    @Autowired
    public ProductService(ProductRepo pr, UserRepo ur) {
        this.pr = pr;
        this.ur = ur;
    }

    public Product create(Product p) {

        p.setProduct_id(0);
        p.setSeller(ur.getById(1));
        return pr.save(p);
    }

    public Product deactivate(int product_id) {
        Product p = pr.getById(product_id);
        p.setStatusid(ProductStatus.Close);
        return pr.save(p);
    }

    public Product activate(int product_id) {
        Product p = pr.getById(product_id);
        p.setStatusid(ProductStatus.Open);
        return pr.save(p);
    }

    public List<Product> getAllProducts() {
        return pr.findAll();
    }

    public List<Product> getAllProductsByStatus(ProductStatus s) {
        return pr.findAllByStatusid(s);
    }

    public List<Product> getSellerProducts(User p) {
        return pr.findAllBySeller(p);
    }

    public List<Product> getLikeName(String s) {
        return pr.findByNameContaining(s);
    }

    public List<Product> getLikeNameAndStatus(String s, ProductStatus ps) {
        return pr.findByNameContainingAndStatusid(s, ps);
    }

}
