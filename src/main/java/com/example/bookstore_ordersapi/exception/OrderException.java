package com.example.bookstore_ordersapi.exception;

public class OrderException extends RuntimeException{
    public OrderException(String exception){
        super(exception);
    }
}
