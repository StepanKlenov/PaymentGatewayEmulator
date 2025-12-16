package com.example.PaymentGatewayEmulator.gui;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;
import com.example.PaymentGatewayEmulator.service.PaymentGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Этот контроллер используется специально для AJAX-запросов
 * из формы, чтобы возвращать чистый JSON, а не HTML-шаблон.
 */
@RestController
@RequestMapping("/ajax/mock-payment")
public class AjaxPaymentController {

    private final PaymentGateway paymentGateway;

    public AjaxPaymentController(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    /**
     * Обрабатывает асинхронный платежный запрос.
     * @RequestBody автоматически преобразует входящий JSON в DTO.
     * Возвращает JSON-ответ (PaymentResponseDTO).
     */
    @PostMapping("/process-ajax")
    public PaymentResponseDTO processPayment(@RequestBody PaymentRequestDTO request) throws InterruptedException {

        // Искусственная задержка 1 секунду, чтобы пользователь увидел анимацию "загрузки"
        Thread.sleep(1000);

        System.out.println("--- AJAX REQUEST RECEIVED AND PROCESSED ---");
        System.out.println("Card: " + request.getCardNumber() + ", Amount: " + request.getAmount());

        // Вызываем логику эмулятора (которая решает SUCCESS или FAILED)
        PaymentResponseDTO response = paymentGateway.processPayment(request);

        System.out.println("--- AJAX RESPONSE SENT --- Status: " + response.getStatus());

        return response;
    }
}