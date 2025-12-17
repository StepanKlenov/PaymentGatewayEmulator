package com.example.PaymentGatewayEmulator.gui;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;
import com.example.PaymentGatewayEmulator.service.MockPaymentGateway; // Проверь этот импорт
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ajax/mock-payment")
public class AjaxPaymentController {

    private final MockPaymentGateway mockPaymentGateway;

    // В конструкторе меняем PaymentGateway на MockPaymentGateway
    public AjaxPaymentController(MockPaymentGateway mockPaymentGateway) {
        this.mockPaymentGateway = mockPaymentGateway;
    }

    @PostMapping("/process-ajax")
    public PaymentResponseDTO process(@RequestBody PaymentRequestDTO request) {
        return mockPaymentGateway.processPayment(request);
    }
}