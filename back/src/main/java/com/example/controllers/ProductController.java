package com.example.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.exeptions.NotASellerException;
import com.example.exeptions.NotLoginException;
import com.example.modules.Product;
import com.example.modules.User;
import com.example.modules.enums.ProductStatus;
import com.example.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controllers.AuthController.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private ProductService ps;

    public ProductController() {
    }

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Product p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.I_AM_A_TEAPOT);
        if (isCustomer(u))
            return new ResponseEntity<>(new NotASellerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.create(p), HttpStatus.ACCEPTED);
    }

    @PutMapping("/deactivate")
    public ResponseEntity<Object> deactivate(@RequestBody Product p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (isCustomer(u))
            return new ResponseEntity<>(new NotASellerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.deactivate(p.getProduct_id()), HttpStatus.ACCEPTED);
    }

    @PutMapping("/activate")
    public ResponseEntity<Object> activate(@RequestBody Product p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (isCustomer(u))
            return new ResponseEntity<>(new NotASellerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.activate(p.getProduct_id()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(HttpSession session) {
        User u = isLogin(session);
        if (u == null || isCustomer(u))
            return ps.getAllProductsByStatus(ProductStatus.Open);
        return ps.getAllProducts();
    }

    @GetMapping("/list/{name}")
    public List<Product> getLikeName(@PathVariable("name") String name, HttpSession session) {
        User u = isLogin(session);
        if (u == null || isCustomer(u))
            return ps.getLikeNameAndStatus(name, ProductStatus.Open);
        return ps.getLikeName(name);
    }

}
