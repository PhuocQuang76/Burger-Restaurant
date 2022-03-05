package com.example.exeptions;

public class NotASellerException extends Exception {
    public NotASellerException() {
        super("This user in not a seller");
    }
}
