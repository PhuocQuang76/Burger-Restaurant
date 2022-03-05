package com.example.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.exeptions.NotACustomerException;
import com.example.exeptions.NotASellerException;
import com.example.exeptions.NotLoginException;
import com.example.modules.Purchase;
import com.example.modules.User;
import com.example.modules.enums.PurchasesStatus;
import com.example.services.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import static com.example.controllers.AuthController.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin("http://localhost:4200")
public class PurchaseController {

    private PurchaseService ps;

    public PurchaseController() {
    }

    @Autowired
    public PurchaseController(PurchaseService ps) {
        this.ps = ps;
    }

    @GetMapping("/")
    public List<Purchase> getAllPurchases() {
        return ps.getAllPurchases();
    }

    @GetMapping("/list/user")
    public ResponseEntity<Object> getAllPurchases(HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (!isCustomer(u))
            return new ResponseEntity<>(ps.getAllPurchases(), HttpStatus.ACCEPTED);
        return new ResponseEntity<>(ps.getAllPurchasesByUser(u.getUser_id()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/cart/user")
    public ResponseEntity<Object> getAllCartItems(HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (!isCustomer(u))
            return new ResponseEntity<>(new NotACustomerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.getAllCartItems(u.getUser_id()), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody Purchase p, HttpSession session) {
        p.setPurchase_id(0);
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (!isCustomer(u))
            return new ResponseEntity<>(new NotACustomerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        p.setBuyer(u);
        return new ResponseEntity<>(ps.create(p), HttpStatus.ACCEPTED);
    }

    @PutMapping("/pending")
    @ResponseBody
    public ResponseEntity<Object> pending(@RequestBody Purchase p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (!isCustomer(u))
            return new ResponseEntity<>(new NotACustomerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.setStatus(p.getPurchase_id(), PurchasesStatus.Pending), HttpStatus.ACCEPTED);
    }

    @PutMapping("/cancel")
    @ResponseBody
    public ResponseEntity<Object> cancel(@RequestBody Purchase p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (isCustomer(u))
            return new ResponseEntity<>(new NotASellerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.setStatus(p.getPurchase_id(), PurchasesStatus.Cancelled), HttpStatus.ACCEPTED);
    }

    @PutMapping("/confirm")
    @ResponseBody
    public ResponseEntity<Object> confirm(@RequestBody Purchase p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (isCustomer(u))
            return new ResponseEntity<>(new NotASellerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.setStatus(p.getPurchase_id(), PurchasesStatus.Confirmed), HttpStatus.ACCEPTED);
    }

    @PutMapping("/delivery")
    @ResponseBody
    public ResponseEntity<Object> delivery(@RequestBody Purchase p, HttpSession session) {
        User u = isLogin(session);
        if (u == null)
            return new ResponseEntity<>(new NotLoginException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        if (isCustomer(u))
            return new ResponseEntity<>(new NotASellerException().getMessage(), HttpStatus.EXPECTATION_FAILED);
        return new ResponseEntity<>(ps.delivery(p.getPurchase_id()), HttpStatus.ACCEPTED);
    }

}
