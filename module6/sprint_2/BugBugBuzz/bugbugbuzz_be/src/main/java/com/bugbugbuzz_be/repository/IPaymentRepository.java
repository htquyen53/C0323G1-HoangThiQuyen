package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
