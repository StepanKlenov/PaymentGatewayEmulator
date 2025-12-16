package com.example.PaymentGatewayEmulator.dto;

public class PaymentRequestDTO {
    private String cardNumber;
    private String amount;
    private String currency;

    // ГЕТТЕРЫ (Getters)
    public String getCardNumber() {
        return cardNumber;
    }
    public String getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

    // СЕТТЕРЫ (Setters)
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}