package com.example;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.pay(100);

        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.pay(200);

        context.setPaymentStrategy(new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
        context.pay(300);
    }
}