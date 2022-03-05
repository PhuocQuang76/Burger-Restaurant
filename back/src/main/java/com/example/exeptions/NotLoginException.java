package com.example.exeptions;

public class NotLoginException extends Exception {
    public NotLoginException() {
        super("This user is not log in");
    }
}
