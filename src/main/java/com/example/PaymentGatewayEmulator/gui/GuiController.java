package com.example.PaymentGatewayEmulator.gui;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;
import com.example.PaymentGatewayEmulator.service.PaymentGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Важно: здесь должен быть @Controller
public class GuiController {

    private final PaymentGateway paymentGateway;

    public GuiController(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Этот метод отображает форму при первом заходе на /
    @GetMapping("/")
    public String showForm(Model model) {
        // Нам все еще нужен этот метод, чтобы Thymeleaf мог отобразить форму paymentForm.html
        // Хотя обработка формы будет происходить через AJAX!
        model.addAttribute("request", new PaymentRequestDTO());
        return "paymentForm";
    }

    // Мы можем удалить или оставить этот старый метод, он больше не используется AJAX-формой.
    // Я рекомендую его УДАЛИТЬ, чтобы избежать путаницы.
    /*
    @PostMapping("/process-form")
    public String processForm(@ModelAttribute("request") PaymentRequestDTO request, Model model) {
        // Этот метод больше не нужен, так как форма теперь отправляется через AJAX на /ajax/mock-payment/process-ajax
        PaymentResponseDTO response = paymentGateway.processPayment(request);
        model.addAttribute("response", response);
        return "paymentForm";
    }
    */
}
// Здесь не должно быть никакого другого кода класса!