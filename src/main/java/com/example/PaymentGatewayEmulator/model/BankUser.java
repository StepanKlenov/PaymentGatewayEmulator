package com.example.PaymentGatewayEmulator.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_users") // Название таблицы в базе данных
public class BankUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;

    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    // Конструктор без параметров (обязателен для JPA)
    public BankUser() {
    }

    // Конструктор для удобства (используется в генераторе)
    public BankUser(String cardNumber, String cardholderName, BigDecimal balance, boolean isBlocked) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.balance = balance;
        this.isBlocked = isBlocked;
    }

    // --- ГЕТТЕРЫ И СЕТТЕРЫ ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}