package com.example.services;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import com.example.modules.Purchase;
import com.example.modules.User;
import com.example.modules.enums.PurchasesStatus;
import com.example.repository.ProductRepo;
import com.example.repository.PurchaseRepo;
import com.example.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.services.EmailMessage.sendmail;

@Service
@Transactional
public class PurchaseService {
    private PurchaseRepo pr;
    private UserRepo ur;
    private ProductRepo proR;

    public PurchaseService() {
    }

    @Autowired
    public PurchaseService(PurchaseRepo pr, UserRepo ur, ProductRepo proR) {
        this.pr = pr;
        this.ur = ur;
        this.proR = proR;
    }

    public List<Purchase> getAllPurchases() {
        return pr.findAll();
    }

    public Purchase create(Purchase p) {
        p.setBuyer(ur.getById(p.getBuyer().getUser_id()));
        p.setProduct(proR.getById(p.getProduct().getProduct_id()));
        p.setPurchase(new Timestamp(System.currentTimeMillis()));
        p = pr.save(p);
        try {
            sendmail(p);
        } catch (MessagingException | IOException e) {
            System.out.println("the email was not send");
            System.out.println(e);
        }
        return p;
    }

    public Purchase delivery(int purchase_id) {
        Purchase p = pr.getById(purchase_id);
        p.setStatusid(PurchasesStatus.Delivered);
        p.setDelivery(new Timestamp(System.currentTimeMillis()));
        return pr.save(p);
    }

    public List<Purchase> getAllPurchasesByUser(int id) {
        User u = ur.getById(id);
        return pr.findAllByBuyerAndStatusidNot(u, PurchasesStatus.Cart);
    }

    public List<Purchase> getAllCartItems(int user_id) {
        User u = ur.getById(user_id);
        return pr.findAllByBuyerAndStatusid(u, PurchasesStatus.Cart);
    }

    public Purchase setStatus(int purchase_id, PurchasesStatus status) {
        Purchase p = pr.getById(purchase_id);
        p.setStatusid(status);
        return pr.save(p);
    }

}
