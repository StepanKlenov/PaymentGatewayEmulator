package com.example.PaymentGatewayEmulator.service;

import com.example.PaymentGatewayEmulator.dto.PaymentRequestDTO;
import com.example.PaymentGatewayEmulator.dto.PaymentResponseDTO;
import com.example.PaymentGatewayEmulator.model.BankUser;
import com.example.PaymentGatewayEmulator.repository.BankUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class MockPaymentGateway {

    @Autowired
    private BankUserRepository bankUserRepository;

    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {
        PaymentResponseDTO response = new PaymentResponseDTO();
        response.setTransactionId(UUID.randomUUID().toString());

        // 1. Поиск карты в базе
        Optional<BankUser> userOpt = bankUserRepository.findByCardNumber(request.getCardNumber());

        if (userOpt.isEmpty()) {
            response.setStatus("FAILED");
            response.setMessage("Карта не найдена в базе банка");
            return response;
        }

        BankUser user = userOpt.get();

        // 2. Проверка блокировки
        if (user.isBlocked()) {
            response.setStatus("FAILED");
            response.setMessage("Карта заблокирована");
            return response;
        }

        // 3. Проверка баланса (BigDecimal требует compareTo)
        BigDecimal amountToPay = request.getAmount();
        if (user.getBalance().compareTo(amountToPay) < 0) {
            response.setStatus("FAILED");
            response.setMessage("Недостаточно средств. Баланс: " + user.getBalance());
            return response;
        }

        // 4. Списание и сохранение
        user.setBalance(user.getBalance().subtract(amountToPay));
        bankUserRepository.save(user);

        response.setStatus("SUCCESS");
        response.setMessage("Оплачено успешно. Остаток: " + user.getBalance());

        return response;
    }
}