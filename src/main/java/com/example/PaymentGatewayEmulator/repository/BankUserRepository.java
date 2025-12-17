package com.example.PaymentGatewayEmulator.repository;

import com.example.PaymentGatewayEmulator.model.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BankUserRepository extends JpaRepository<BankUser, Long> {
    Optional<BankUser> findByCardNumber(String cardNumber);
}