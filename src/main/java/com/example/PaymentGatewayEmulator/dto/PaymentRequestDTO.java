package com.example.PaymentGatewayEmulator.dto;

import java.math.BigDecimal; // Обязательный импорт для работы с деньгами

public class PaymentRequestDTO {
    private String cardNumber;
    private BigDecimal amount; // ИСПРАВЛЕНО: тип String заменен на BigDecimal
    private String currency;

    // ГЕТТЕРЫ (Getters)
    public String getCardNumber() {
        return cardNumber;
    }

    public BigDecimal getAmount() { // ИСПРАВЛЕНО: возвращает BigDecimal
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    // СЕТТЕРЫ (Setters)
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setAmount(BigDecimal amount) { // ИСПРАВЛЕНО: принимает BigDecimal
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}