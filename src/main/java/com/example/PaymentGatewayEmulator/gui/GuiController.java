package com.example.PaymentGatewayEmulator.gui;

import com.example.PaymentGatewayEmulator.service.MockPaymentGateway; // Важный импорт
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiController {

    private final MockPaymentGateway mockPaymentGateway;

    // Исправляем конструктор: меняем PaymentGateway на MockPaymentGateway
    public GuiController(MockPaymentGateway mockPaymentGateway) {
        this.mockPaymentGateway = mockPaymentGateway;
    }

    @GetMapping("/")
    public String index(Model model) {
        // Здесь можно добавить логику для отображения главной страницы шлюза
        return "index";
    }
}