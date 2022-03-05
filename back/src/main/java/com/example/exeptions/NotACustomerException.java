package com.example.exeptions;

public class NotACustomerException extends Exception {
    public NotACustomerException() {
        super("This user in not a Customer");
    }
}
