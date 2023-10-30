package com.bugbugbuzz_be.repository.payment;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findPaymentByAppUser(AppUser appUser);
}
