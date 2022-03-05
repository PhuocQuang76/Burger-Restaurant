package com.example.repository;

import java.util.List;

import com.example.modules.Purchase;
import com.example.modules.User;
import com.example.modules.enums.PurchasesStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {

    List<Purchase> findAllByBuyer(User u);

    List<Purchase> findAllByBuyerAndStatusid(User u, PurchasesStatus cart);

    List<Purchase> findAllByBuyerAndStatusidNot(User u, PurchasesStatus cart);

}
