package com.example.paymentservice;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
