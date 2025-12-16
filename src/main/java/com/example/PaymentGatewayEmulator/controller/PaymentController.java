package com.example.PaymentGatewayEmulator.controller;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;
import com.example.PaymentGatewayEmulator.service.PaymentGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mock-payment")
public class PaymentController {

    // Spring автоматически внедрит наш MockPaymentGateway сюда
    private final PaymentGateway paymentGateway;

    public PaymentController(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDTO> processPayment(@RequestBody PaymentRequestDTO request) {

        System.out.println("--- RECEIVED PAYMENT REQUEST ---");
        System.out.println("Card: " + request.getCardNumber() + ", Amount: " + request.getAmount());

        // Вызываем наш эмулируемый шлюз
        PaymentResponseDTO response = paymentGateway.processPayment(request);

        System.out.println("--- MOCK RESPONSE --- Status: " + response.getStatus());

        return ResponseEntity.ok(response);
    }
}