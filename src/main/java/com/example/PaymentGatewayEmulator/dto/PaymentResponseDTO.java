package com.example.PaymentGatewayEmulator.dto;

public class PaymentResponseDTO {
    private String transactionId;
    private String status;
    private String message;
    private String gateway;

    // ГЕТТЕРЫ
    public String getTransactionId() {
        return transactionId;
    }
    public String getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public String getGateway() {
        return gateway;
    }

    // СЕТТЕРЫ
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
}