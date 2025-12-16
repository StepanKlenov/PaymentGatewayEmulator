// класс эмуляции

package com.example.PaymentGatewayEmulator.service;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class MockPaymentGateway implements PaymentGateway {

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {

        String transactionId = UUID.randomUUID().toString();
        PaymentResponseDTO response = new PaymentResponseDTO();

        // --- ЛОГИКА ЭМУЛЯЦИИ ---
        // Имитация отказа: если номер карты начинается с '555',
        // то шлюз отвечает FAIL.
        if (request.getCardNumber() != null && request.getCardNumber().startsWith("555")) {
            response.setStatus("FAILED");
            response.setMessage("Transaction declined (Mock code: 555 - Test Failure)");
        }
        // В остальных случаях - УСПЕХ
        else {
            response.setStatus("SUCCESS");
            response.setMessage("Payment processed successfully.");
        }
        // --- КОНЕЦ ЛОГИКИ ЭМУЛЯЦИИ ---

        response.setTransactionId(transactionId);
        response.setGateway("MockGateway");

        return response;
    }
}