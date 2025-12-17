package com.example.PaymentGatewayEmulator.config;

import com.example.PaymentGatewayEmulator.model.BankUser;
import com.example.PaymentGatewayEmulator.repository.BankUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BankUserRepository repository;

    public DataInitializer(BankUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            for (int i = 1; i <= 20; i++) {
                BankUser user = new BankUser();
                // Номера карт: 4111000000000001, 4111000000000002...
                user.setCardNumber(String.format("41110000000000%02d", i));
                user.setCardholderName("USER " + i);
                user.setBalance(new BigDecimal("10000.00")); // Баланс 10 000 руб
                user.setBlocked(i % 5 == 0); // Каждая 5-я карта заблокирована
                repository.save(user);
            }
            System.out.println(">>> База Шлюза заполнена: 20 тестовых карт создано.");
        }
    }
}