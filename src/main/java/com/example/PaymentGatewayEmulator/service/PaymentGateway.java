package com.example.PaymentGatewayEmulator.service;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;

public interface PaymentGateway {

    // Метод для обработки платежа, который принимает запрос и возвращает ответ
    PaymentResponseDTO processPayment(PaymentRequestDTO request);
}